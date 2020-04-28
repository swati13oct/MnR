/**
 * 
 */
package pages.acquisition.planRecommendationEngine;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.AcquisitionHomePage;

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
	
	@FindBy(css = "#uhcSVGLogo > svg")
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
    
    @FindBy(css = "#subnav_2 div[class$='content-2']>h3:nth-of-type(1)>a")
    private WebElement headerAdvantageplanLink;
    
    @FindBy(css = "#subnav_2 div[class$='content-2'] div:nth-of-type(1) a") 
    private WebElement headerMedicaresupplementplanLink;
    
    @FindBy(css = "#subnav_2 div[class='content content-2'] h3:nth-of-type(2)>a")
    private WebElement headerPrescriptionLink;
    
    @FindBy(css = "#subnav_2 div[class='content content-2'] h3:nth-of-type(3)>a")
    private WebElement headerGetaPlanRecommendationLink;
    
    @FindBy(css = "#subnav_2 div[class='content content-2'] h3:nth-of-type(4)>a")
    private WebElement headerDrugcostLink;
    
    @FindBy(css = "#subnav_2 div[class='content content-2'] h3:nth-of-type(5)>a")
    private WebElement headerPharmacysearchLink;
    
    @FindBy(css = "#subnav_2 div[class='content content-2'] h3:nth-of-type(6)>a")
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
    
    @FindBy(css = "#subnav_3 div[class$='content-2'] li:nth-of-type(1)>a")
    private WebElement headerMedicareadvantageLink;
    
    @FindBy(css = "#subnav_3 div[class$='content-2'] li:nth-of-type(2) a") //Geotargetting
    private WebElement headerMedicaresupplemnetLink;
    
    @FindBy(css = "#subnav_3 div[class$='content-2'] li:nth-of-type(3)>a")
    private WebElement headerMedicareprescriptionLink;
    
    @FindBy(css = "#subnav_3 div[class$='content-3']>div ul>li a")
    private WebElement headerEnrollment;
    
    @FindBy(css = "#subnav_3 div[class$='content-3'] li:nth-of-type(1)>a")
    private WebElement headerFAQLink;

//'Get Help Choosing' is Inside Shop Menu
    
    @FindBy(xpath = "//span[contains(text(),'Get Help Choosing')]")
	private WebElement HeaderShopToolsGetHelpChoosingLink;
	
//Footer Elements
	
	@FindBy(xpath = "//footer[@class='footer']")
	private WebElement footerSection;
	
	@FindBy(css = "ul.visitaarp.linksCond > li > a")
	private WebElement footerVisitAARPOrgLink;
	
	@FindBy(css = "#gfn_lnk_row2_1 > span")
	private WebElement footerMedicareAdvantagePlansLink;
		
	@FindBy(css = "#_zbe2trg1n")
	private WebElement footerMedicareSupplementInsurancePlansLink;
	
	@FindBy(css = "#gfn_lnk_row2_4 > span")
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
        
	
	
//Header Element Verification Method 
	
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
		actions.moveToElement(headerNavigationBarShopForaPlanTab).perform();
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
//2nd column in Shop for a plan		
		validate(headerShopLink, 30);
		Assert.assertTrue(headerShopLink.getText().contains("Shop"));
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
		System.out.println("Validating Learn About Medicare Elements: ");
		actions.moveToElement(headerNavigationBarLearnAboutMedicareTab).perform();
		validate(headerEligibilityLink, 30);		
		validate(headerCoverageLink, 30);
		validate(headermedicarePrescriptionProviderLink, 30);
		validate(headerCostbasicsLink, 30);
		validate(headerMedicareadvantageLink, 30);
		validate(headerMedicaresupplemnetLink, 30);
		validate(headerMedicareprescriptionLink, 30);
		validate(headerEnrollment, 30);
		validate(headerFAQLink, 30);  //GeoTargeting Element
	}
	
	
//	Header Element Click Verification Method 
	
		public void headerLinkvalidation(){
			String curURL = driver.getCurrentUrl();			
			headerSigninLink.click();
			if (curURL.contains("aarpmedicare"))
				validateLinks("medicare.uhc.com/aarp");
			else
				validateLinks("medicare.uhc.com");
		browserBack();
		
		headerRegisterLink.click();
		validateLinks("healthsafe-id.com/register/personalInfo");
		
		backtoshopforaplan();
		headerShopForaPlanLookupZipcode.click();
		validateLinks("/health-plans.html?lookupZipcode");
		backtoshopforaplan();
		headerShopForaPlanRequestMoreHelp.click();
		validateLinks("health-plans/shop/connect");
		backtoshopforaplan();
		headerShopLink.click();
		validateLinks("/health-plans/shop.html");
		backtoshopforaplan();
		headerEnrollLink.click();
		validateLinks("/health-plans/enroll.html");
		backtoshopforaplan();
		headerResourcesLink.click();
		validateLinks("/health-plans/resources.html");
		backtoshopforaplan();
		headerAdvantageplanLink.click();
		validateLinks("/health-plans/shop/medicare-advantage-plans.html");
		backtoshopforaplan();
		headerMedicaresupplementplanLink.click();
		validateLinks("/health-plans/shop/medicare-supplement-plans.html||health-plans.html?product=");
		backtoshopforaplan();
		headerPrescriptionLink.click();
		validateLinks("/health-plans/shop/prescription-drug-plans.html");
		backtoshopforaplan();
		headerGetaPlanRecommendationLink.click();
		validateLinks("/plan-recommendation-engine.html");
		backtoshopforaplan();
		headerDrugcostLink.click();
		validateLinks("health-plans/estimate-drug-costs.html");
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
		backtolearnmoremodicare();
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
		
		}
		
// PRE BreadCrumbs in Header	
		
		public void breadCrumbs() {
			String preBreadcrumbs = (driver.findElement(By.cssSelector("div.breadcrumb"))).getText();
			Assert.assertTrue(preBreadcrumbs.contains("Home / Plan Recommendation Engine"));
			System.out.println(preBreadcrumbs);
		}
		
//	Footer Element Verification Method
	
	public void footerElements() {
		System.out.println("Validating Footer Elements: ");
		String actualpageurl = driver.getCurrentUrl();
		if(actualpageurl.contains("aarpmedicareplans")) {
			validate(footerVisitAARPOrgLink, 30);
			Assert.assertTrue(footerVisitAARPOrgLink.getText().contains("Visit AARP.org"));
		}
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
		validateLinks("/health-plans/shop/medicare-advantage-plans");
		browserBack();
		footerMedicareSupplementInsurancePlansLink.click();
		validateLinks("/health-plans/shop/medicare-supplement-plans||health-plans.html?product=");
		browserBack();
		
		footerMedicarePrescriptionDrugPlansLink.click();
		validateLinks("/health-plans/shop/prescription-drug-plans");
		browserBack();

		footerMedicareEducationLink.click();
		validateLinks("/medicare-education.html");
		browserBack();

		footerHomeLink.click();
		if (driver.getCurrentUrl().contains("aarpmedicare")) {
			validateLinks("aarpmedicareplans.ocp-elr-core-nonprod.optum.com");
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
		validateLinks("/privacy_policy.html");
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
	public void navigationToPlanRecommendationEngine() throws InterruptedException{
		/*validate(headerNavigationBarShopForaPlanTab, 45);
		actions.moveToElement(headerNavigationBarShopForaPlanTab).perform();
		 Thread.sleep(10000);
		 validate(headerGetaPlanRecommendationLink, 30);
		 actions.moveToElement(headerGetaPlanRecommendationLink,20,0).click().perform();*/
		actions.moveToElement(headerNavigationBarShopForaPlanTab).click(headerGetaPlanRecommendationLink).build().perform();
		validate(landingpageHeader, 30);
		Assert.assertTrue(landingpageHeader.getText().contains("plan"));
	}
	
//Navigating Plan RecommendationEngine via Shop for a plan -->Shop-->Tools-->Get Help Choosing	
	public void navigationToPlanRecommendationEngineViaShopTools() {
		validate(headerNavigationBarShopForaPlanTab, 45);
		actions.moveToElement(headerNavigationBarShopForaPlanTab).perform();
		headerShopLink.click();
		validate(HeaderShopToolsGetHelpChoosingLink, 30);
		HeaderShopToolsGetHelpChoosingLink.click();
		validate(landingpageHeader, 30);
		Assert.assertTrue(landingpageHeader.getText().contains("plan"));
	}
	
//ZipCode Function inside Shop for a Plan
	public void zipcodeFunctionInShopforaplan(String zipcode) throws InterruptedException {
		validate(headerNavigationBarShopForaPlanTab, 45);
		actions.moveToElement(headerNavigationBarShopForaPlanTab).perform();
		headerShopForaPlanZipcodeBox.click();
		headerShopForaPlanZipcodeBox.sendKeys(zipcode);
		headerShopForaPlanZipcodeButton.click();
		Thread.sleep(5000);
		validateLinks("/plan-summary");
		headerNavigationBarHomeTab.click();
		navigationToPlanRecommendationEngine();
	}
	
//Email Function inside Shop for a Plan	
	public void emailFunctionInShopforaplan(String email) {
		validate(headerNavigationBarShopForaPlanTab, 45);
		actions.moveToElement(headerNavigationBarShopForaPlanTab).perform();
		headerShopForaPlanEmailBox.click();
		headerShopForaPlanEmailBox.sendKeys(email);
		headerShopForaPlanEmailButton.click();
		validate(headerShopForaPlanThankYou, 60);
		try {
			validate(closeIcon,30);
			validate(closeIcon, 60);
			closeIcon.click();
			validate(headerNavigationBarHomeTab, 60);
			headerNavigationBarHomeTab.click();
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
		headerNavigationBarSearchIconTab.click();
		String expectedpageurl = driver.getCurrentUrl();
		String ExpectedPage = "search-medicare.html?";
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
		footerBackToTopLink.click();
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
		validate(headerNavigationBarShopForaPlanTab, 45);
		actions.moveToElement(headerNavigationBarShopForaPlanTab).perform();
	}
	
	public void backtolearnmoremodicare() {
		browserBack();
		validate(headerNavigationBarLearnAboutMedicareTab, 45);
		actions.moveToElement(headerNavigationBarLearnAboutMedicareTab).perform();
	}
	
	public void navigatesubLink(String subURL) {
		driver.navigate().to(subURL);
	}
	
	public void validateLinksanotherWindow(String expURL, String primaryWindow) {
		threadsleep(2000);
		ArrayList<String> windows = new ArrayList<String> (driver.getWindowHandles());
		System.out.println(windows);
		if (windows.size() >= 2) {
			driver.switchTo().window(windows.get(2)); 	
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
