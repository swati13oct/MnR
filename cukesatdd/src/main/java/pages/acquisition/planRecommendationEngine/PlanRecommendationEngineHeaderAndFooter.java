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
import org.testng.Assert;

import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.AcquisitionHomePage;

public class PlanRecommendationEngineHeaderAndFooter extends UhcDriver {
	
	Actions actions = new Actions(driver);

	public PlanRecommendationEngineHeaderAndFooter(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, AcquisitionHomePage.proactiveChatExitBtn, 30);
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
	
	@FindBy(xpath = "//*[@id='aarpSVGLogo']/img")
	private WebElement AARPlogoInHeader;
	
	@FindBy(css = "#uhcSVGLogo")
	private WebElement UHClogoInHeader;
	
	@FindBy(css = ".companyNameHeader>p")
	private WebElement companyNameUnderAARPlogoInHeader;
	
	@FindBy(xpath = "//a[@id='aarplink']")
	private WebElement headerVisitAARPOrgLink;
	
	@FindBy(xpath = "//*[@class='signup']/span[1]")
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
	
	@FindBy(css = "a[dtmname*='Shop For a Plan']")
	private WebElement headerNavigationBarShopForaPlanTab;
	
	@FindBy(css = "a[dtmname*='Learn About Medicare']")
	private WebElement headerNavigationBarLearnAboutMedicareTab;
	
	@FindBy(xpath = "//*[@id='mobile-nav']/div/div[2]/form/div/input")
	private WebElement headerNavigationBarEnterSearchTab;
	
	@FindBy(css = "#nav_search_icon>svg")
	private WebElement headerNavigationBarSearchIconTab;
	
//Inside Shop for a Plan Elements
	
	@FindBy(css = "#subnav_2 > div.scroll-wrapper > div > div:nth-child(1) > label")
	private WebElement headerShopForaPlanFindplansinyourarea;
	
	@FindBy(css = ".zip-form #nav-zipcode")
	private WebElement headerShopForaPlanZipcodeBox;
	
	@FindBy(css = ".zip-form .zip-button")
	private WebElement headerShopForaPlanZipcodeButton;
	
	@FindBy(xpath = "//*[@id='subnav_2']//*[@class='zip-lookup']")
	private WebElement headerShopForaPlanNeedQuestionofZipcode;
	
	@FindBy(css = ".zip-lookup>a")
	private WebElement headerShopForaPlanLookupZipcode;
	
	@FindBy(css = "#subnav_2 .nav-col>a")
	private WebElement headerShopForaPlanRequestMoreHelp;
	
	@FindBy(xpath = "//*[@id='updates-mobile-form']//*[@class='email-col']/h4")
	private WebElement headerShopForaPlanMedicareGuide;
	
	@FindBy(xpath = "//*[@id='updates-mobile-form']//*[@class='email-col']/p")
	private WebElement headerShopForaPlanMedicareGuideText;
	
	@FindBy(css = "#updates-mobile-form > div > div:nth-child(2)>span>input")
	private WebElement headerShopForaPlanEmailBox;
	
	@FindBy(css = "#updates-mobile-form > div > div:nth-child(2) > button")
	private WebElement headerShopForaPlanEmailButton;
	
	@FindBy(css = "#subnav_2 > div.nav-col-emailupdate.ng-scope > div")
	private WebElement headerShopForaPlanThankYou;
	
	@FindBy(css = "#planTypesColumn h3:nth-of-type(1)>a")
    private WebElement headerShopLink;
    
    @FindBy(css = "#planTypesColumn h3:nth-of-type(2)>a")
    private WebElement headerEnrollLink;
    
    @FindBy(css = "#planTypesColumn h3:nth-of-type(3)>a")
    private WebElement headerResourcesLink;
    
//    @FindBy(css = "#planTypesColumn h3:nth-of-type(4)>a")
//    private WebElement headerResourcesLink;
    
    @FindBy(css = "#subnav_2 div[class$='content-2']>h3:nth-of-type(1)>a")
    private WebElement headerAdvantageplanLink;
    
    @FindBy(css = "#subnav_2 div[class$='content-2']>h3:nth-of-type(2)>a")
	private WebElement headerDualSpecialLink;

	@FindBy(css = "#subnav_2 div[class$='content-2']>h3:nth-of-type(3)>span:nth-of-type(2)>a")
    private WebElement headerMedicaresupplementplanLink;
    
	@FindBy(css = "#subnav_2 div[class$='content-2']>h3:nth-of-type(5)>a")
    private WebElement headerPrescriptionLink;
    
    @FindBy(xpath = "//a[contains(text(),'Get a Plan Recommendation')]")
    private WebElement headerGetaPlanRecommendationLink;
    
    @FindBy(linkText = "Drug Cost Estimator")
    private WebElement headerDrugcostLink;
    
    @FindBy(linkText = "Pharmacy Search")
    private WebElement headerPharmacysearchLink;
    
    @FindBy(linkText = "Provider Search")
    private WebElement headerProvidersearchLink;
    
 //Learn about Medicare inner element
        
    @FindBy(css = "#subnav_3 div[class$='content-1'] ul>li:nth-of-type(1)>a")
    private WebElement headerEligibilityLink;
    
    @FindBy(css = "#subnav_3 div[class$='content-1'] ul>li:nth-of-type(2)>a")
    private WebElement headerCoverageLink;
    
    @FindBy(css = "#subnav_3 div[class$='content-1'] ul>li:nth-of-type(3)>a")
    private WebElement headermedicarePrescriptionProviderLink;
    
    @FindBy(css = "#subnav_3 div[class$='content-1'] ul>li:nth-of-type(4)>a")
    private WebElement headerCostbasicsLink;
    
    @FindBy(css = "#subnav_3 div[class$='content-2'] ul:nth-of-type(1) li:nth-of-type(1)>a")
    private WebElement headerMedicareadvantageLink;
    
    @FindBy(css = "#subnav_3 div[class$='content-2'] ul:nth-of-type(1) li:nth-of-type(2)>a") //Geotargetting
    private WebElement headerMedicaresupplemnetLink;
    
    @FindBy(css = "#subnav_3 div[class$='content-2'] li:nth-of-type(3)>span>a")
    private WebElement headerMedicareprescriptionLink;
    
    @FindBy(css = "#subnav_3 div[class$='content-2'] ul:nth-of-type(2) li:nth-of-type(1)>a")
    private WebElement headerEnrollment;
    
    @FindBy(css = "#subnav_3 div[class$='content-2'] ul:nth-of-type(2) li:nth-of-type(2)>a")
    private WebElement headerFAQLink;
    
    @FindBy(css = "#subnav_3 div[class$='content-3']>div:nth-child(1)>a")
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
    
    @FindBy(css = "div a[title='Read more about Medicare and COBRA']")
	private WebElement HeaderReadMoreLinkInMedicareArticles;
    
    @FindBy(css = "div a[class*='uhc-tempo-button--primary']")
	private WebElement HeaderGetStartedMedicareArticles;
    
//'Get Help Choosing' is Inside Shop Menu
    
    @FindBy(css = "div[class*='aem-GridColumn'] a[title='Learn More']")
	private WebElement HeaderShopFromHomeInFindYourPlan;
    
    @FindBy(xpath = "//a[contains(text(),'Get Recommendations')]")
	private WebElement HeaderGetRecommendationInShop;
	
//Footer Elements
	
	@FindBy(xpath = "//footer[@class='footer']")
	private WebElement footerSection;
	
	@FindBy(css = "ul.visitaarp.linksCond > li > a")
	private WebElement footerVisitAARPOrgLink;
	
	@FindBy(css = "#gfn_lnk_row2_1 > span")
	private WebElement footerMedicareAdvantagePlansLink;
		
	@FindBy(css = "#gfn_lnk_row2_3 span:nth-of-type(2)")
	private WebElement footerMedicareSupplementInsurancePlansLink;
	
	@FindBy(css = "#gfn_lnk_row2_5 > span")
	private WebElement footerMedicarePrescriptionDrugPlansLink;
	
	@FindBy(css = "#gfn_lnk_row3_1 > span")
	public WebElement footerMedicareEducationLink;
	
	@FindBy(css = ".footer-top>ul>li>a.back-to-top")
	public WebElement footerBackToTopLink;
	
	@FindBy(css = "#stateWidget > div > label")
	public WebElement footerYourState;
	
	@FindBy(css = ".linksCond > #gf_lnk_1 > div")
	public WebElement footerHomeLink;
	
	@FindBy(css = ".linksCond > #gf_lnk_2 > div")
	public WebElement footerAboutUsLink;
	
	@FindBy(css = ".linksCond > #gf_lnk_3 > div")
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
        
// DCE elements
	
	@FindBy(css = "#addDrug")
	private WebElement drugAddBtn;
	
	@FindBy(css = "h1#progressHeader")
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
			Assert.assertTrue(headerVisitAARPOrgLink.getText().contains("Visit AARP.org"));
		}else if(actualpageurl.contains("uhcmedicaresolutions")){
			validate(UHClogoInHeader, 30);
		}
		validate(headerSection, 30);
		validate(headerAlreadyAPlanMember, 30);
		Assert.assertTrue(headerAlreadyAPlanMember.getText().contains("Already a Plan Member?"));
		validate(headerAlreadyAPlanMemberPipeSymbol, 30);
		Assert.assertTrue(headerAlreadyAPlanMemberPipeSymbol.getText().contains("|"));
		validate(headerSigninLink, 30);
		Assert.assertTrue(headerSigninLink.getText().contains("Sign in"));
		validate(headerRegisterLink, 30);
//		Assert.assertTrue(headerRegisterLink.getText().contains("Register"));
		validate(headerHeartNumberofPlan, 30);
		validate(headerNavigationBar, 30);
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
		Assert.assertTrue(headerShopForaPlanNeedQuestionofZipcode.getText().contains("Need help finding a ZIP code? "));
		validate(headerShopForaPlanLookupZipcode, 30);
		validate(headerShopForaPlanRequestMoreHelp, 30);
		validate(headerShopForaPlanMedicareGuide, 30);
		validate(headerShopForaPlanMedicareGuideText, 30);
		validate(headerShopForaPlanEmailBox, 30);
		validate(headerShopForaPlanEmailButton, 30);
//2nd column in Shop for a plan		headerNewExistingMemberLink
		validate(headerShopLink, 30);
		Assert.assertTrue(headerShopLink.getText().contains("Shop"));
//		validate(headerNewExistingMemberLink, 30);
//		Assert.assertTrue(headerNewExistingMemberLink.getText().contains("New and Existing Members"));
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
		Assert.assertTrue(headerDrugcostLink.getText().contains("Drug Cost Estimator"));
		validate(headerPharmacysearchLink, 30);
		Assert.assertTrue(headerPharmacysearchLink.getText().contains("Pharmacy Search"));
		validate(headerProvidersearchLink, 30);
		Assert.assertTrue(headerProvidersearchLink.getText().contains("Provider Search"));

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
		Assert.assertTrue(headerMedicareArticles.getText().contains("Medicare Articles"));
		validate(headerEligibilityEnrollment, 30);
		validate(headerBenefitsCoverage, 30);
		validate(headerMedicareCosts, 30);
		validate(headerShoppingforMedicare, 30);
		validate(headerWorkingPast65, 30);
		validate(headerMedicareTipsFAQs, 30);
	}
	
	
//	Header Element Click Verification Method 
	
		public void headerLinkvalidation(){
			String curURL = driver.getCurrentUrl();			
			headerSigninLink.click();
			if (curURL.contains("aarpmedicare"))
				validateLinks("medicare.uhc.com");
			else
				validateLinks("medicare.uhc.com");
		backtoshopforaplan();
		headerRegisterLink.click();
		validateLinks("healthsafe-id.com/register/personalInfo");
		
		backtoshopforaplan();
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
		validate(headerEnrollment,30);
		navigatesubLink(headerEnrollment.getAttribute("href"));
		validateLinks("/medicare-education/enrollment-and-changing-plans.html");
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
		headerEligibilityEnrollment.click();
		validateLinks("/medicare-articles/eligibility-and-enrollment.html");
		backtolearnmoremodicare();
		headerBenefitsCoverage.click();
		validateLinks("/medicare-articles/medicare-benefits-and-coverage.html");
		backtolearnmoremodicare();
		headerMedicareCosts.click();
		validateLinks("/medicare-articles/medicare-costs.html");
		backtolearnmoremodicare();
		headerShoppingforMedicare.click();
		validateLinks("/medicare-articles/shopping-for-medicare.html");
		backtolearnmoremodicare();
		headerWorkingPast65.click();
		validateLinks("/medicare-articles/medicare-when-working-past-65.html");
		backtolearnmoremodicare();
		headerMedicareTipsFAQs.click();
		validateLinks("/medicare-articles/medicare-tips-and-faqs.html");
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
		String actualpageurl = driver.getCurrentUrl();
		if(actualpageurl.contains("aarpmedicareplans")) {
			validate(footerVisitAARPOrgLink, 30);
			Assert.assertTrue(footerVisitAARPOrgLink.getText().contains("Visit AARP.org"));
		}
		scrollToView(footerSection);
		validate(footerSection, 30);
		validate(footerMedicareAdvantagePlansLink, 30);
		Assert.assertTrue(footerMedicareAdvantagePlansLink.getText().contains("Medicare Advantage Plans"));
		validate(footerMedicareSupplementInsurancePlansLink, 30);	//GeoTargeting Element
		validate(footerMedicarePrescriptionDrugPlansLink, 30);
		Assert.assertTrue(footerMedicarePrescriptionDrugPlansLink.getText().contains("Medicare Prescription Drug Plans"));
		validate(footerMedicareEducationLink, 30);
		Assert.assertTrue(footerMedicareEducationLink.getText().contains("Medicare Education"));
		validate(footerBackToTopLink, 30);
		Assert.assertTrue(footerBackToTopLink.getText().contains("Back to Top"));
		validate(footerHomeLink, 30);
		Assert.assertTrue(footerHomeLink.getText().contains("Home"));
		validate(footerAboutUsLink, 30);
		Assert.assertTrue(footerAboutUsLink.getText().contains("About Us"));
		validate(footerContactUsLink, 30);
		Assert.assertTrue(footerContactUsLink.getText().contains("Contact Us"));
		validate(footerSiteMapLink, 30);
		Assert.assertTrue(footerSiteMapLink.getText().contains("Site Map"));
		validate(footerPrivacyPolicyLink, 30);
		Assert.assertTrue(footerPrivacyPolicyLink.getText().contains("Privacy Policy"));
		validate(footerTermsofUseLink, 30);
		Assert.assertTrue(footerTermsofUseLink.getText().contains("Terms of Use"));
		validate(footerDisclaimersLink, 30);
		Assert.assertTrue(footerDisclaimersLink.getText().contains("Disclaimers"));
		validate(footerAgentsBrokersLink, 30);
		Assert.assertTrue(footerAgentsBrokersLink.getText().contains("Agents & Brokers"));
		validate(footerAccessibilityLink, 30);
		Assert.assertTrue(footerAccessibilityLink.getText().contains("Accessibility"));
		validate(footerCertificateStatement, 30);
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
		if (curURL.contains("aarpmedicare")) {
			validate(AARPlogoInHeader, 30);
			curWindow = driver.getWindowHandle();
			//another window - only aarp
			footerVisitAARPOrgLink.click();
			validateLinksanotherWindow("/health/medicare-insurance/?intcmp",curWindow);
		} else if (curURL.contains("uhcmedicare")) {
			validate(UHClogoInHeader, 30);
			UHClogoInHeader.click();
		}
		footerMedicareAdvantagePlansLink.click();
		validateLinks("/shop/medicare-advantage-plans.html");
		browserBack();
		footerMedicareSupplementInsurancePlansLink.click();
		validateLinks("/shop/medicare-supplement-plans.html");
		browserBack();
		
		footerMedicarePrescriptionDrugPlansLink.click();
		validateLinks("/shop/prescription-drug-plans.html");
		browserBack();

		footerMedicareEducationLink.click();
		validateLinks("/medicare-education.html");
		browserBack();

		footerHomeLink.click();
		if (driver.getCurrentUrl().contains("aarpmedicare")) {
			validateLinks("aarpmedicareplans");
		}else if(driver.getCurrentUrl().contains("uhcmedicaresolutions")) {
			validateLinks("uhcmedicaresolutions");
		}
		navigationToPlanRecommendationEngine();
		footerAboutUsLink.click();
		validateLinks("/about-us.html");
		browserBack();
		footerContactUsLink.click();
		validateLinks("/contact-us.html");
		browserBack();
		footerSiteMapLink.click();
		validateLinks("/sitemap.html");
		browserBack();
		footerPrivacyPolicyLink.click();
		validateLinks("/privacy-policy.html");
		browserBack();
		footerTermsofUseLink.click();
		validateLinks("/terms-of-use.html");
		browserBack();
		footerDisclaimersLink.click();
		validateLinks("/disclaimer.html");
		browserBack();
		footerAgentsBrokersLink.click();
		validateLinks("/health-insurance-brokers.html");
		browserBack();
		if (curURL.contains("uhcmedicare")) {
		footerAccessibilityLink.click();
		validateLinks("/legal/accessibility");
		browserBack();
		}
		else {
			validate(footerAccessibilityLink,30);
		}	
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
		jsClickNew(headerShopLink);
		scrollToView(HeaderShopFromHomeInFindYourPlan);
		validate(HeaderShopFromHomeInFindYourPlan, 30);
		jsClickNew(HeaderShopFromHomeInFindYourPlan);
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
			validate(HeaderReadMoreLinkInMedicareArticles, 30);
			jsClickNew(HeaderReadMoreLinkInMedicareArticles);
			validate(HeaderBreadcrumb, 30);
			Assert.assertTrue(HeaderBreadcrumb.getText().trim().contains("Home / Medicare Articles / Medicare and COBRA"), "Medicare and COBRA page not opened");
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
		validate(headerNavigationBarShopForaPlanTab, 45);
//		actions.clickAndHold(headerNavigationBarShopForaPlanTab).build().perform();
		desktopCommonUtils.MouseOver(headerNavigationBarShopForaPlanTab, Browsername);
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

	public void browserBack() {

		driver.navigate().back();
	}
}
