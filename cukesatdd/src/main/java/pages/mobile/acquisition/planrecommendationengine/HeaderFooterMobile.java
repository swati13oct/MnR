/**
 * 
 */
package pages.mobile.acquisition.planrecommendationengine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import atdd.framework.UhcDriver;
import io.appium.java_client.AppiumDriver;

public class HeaderFooterMobile extends UhcDriver {

	public HeaderFooterMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
	}

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

//Header Elements

	@FindBy(css = "div[class*='nav-toggle']")
	private WebElement headerSectionmenu;
	
	@FindBy(css = "a#uhcSVGLogo")
	private WebElement UHClogoInHeader;
	
	@FindBy(css = "#aarpSVGLogo>img")
	private WebElement AARPlogoInHeader;
	
	@FindBy(css = ".companyNameHeader>p")
	private WebElement headerCompanyname;
	
	@FindBy(css = "a#dupIconFlyOut img[dtmid='acq_visitor_profile']")
	private WebElement headerHeartImage;
	
	@FindBy(css = "a#dupIconFlyOut>span")
	private WebElement headerHeartNumberofPlan;
	
	//Header Menu Elements
	@FindBy(css = "#mobile-nav #visitaarp_lnk")
	private WebElement headerVisitAARPOrgLink;
	
	@FindBy(css = "#mobile-nav .msignup")
	private WebElement headerAlreadyAPlanMember;
	
	@FindBy(css = "#mobile-nav #mRegisterSignupSeperator")
	private WebElement headerAlreadyAPlanMemberPipeSymbol;
	
	@FindBy(css = "#mobile-nav .msignup a:nth-of-type(1)")
	private WebElement headerSigninLink;
	
	@FindBy(css = "#mobile-nav .msignup a:nth-of-type(2)")
	private WebElement headerRegisterLink;
	
	@FindBy(css = "#mobile-nav .nav-logo")
	private WebElement hedearmenuLogo;
	
	@FindBy(css = "#mobile-nav #search-field")
	private WebElement hedearmenuSearchbox;
	
	@FindBy(css = "#mobile-nav #nav_search_icon")
	private WebElement hedearmenuSearchicon;
	
	@FindBy(css = "#mobile-nav a[dtmname*='Shop For a Plan']")
	private WebElement shopforaplanLink;
	
	@FindBy(css = "#mobile-nav a[dtmname*='Learn About Medicare']")
	private WebElement learnaboutmedicareLink;
	
	@FindBy(css = "#subnav_2 .nav-back")
	private WebElement headernavigationBackbutton;
	
	@FindBy(css = "#subnav_3 .nav-back")
	private WebElement headernavigationmedicareBackbutton;
	
	@FindBy(css = "#nav>a.nav-close")
	private WebElement headernavigationCloseicon;
	
	// Shop for a plan inner elements
	@FindBy(css = "#subnav_2 label[for='nav-zipcode']")
	private WebElement headerFindplanslabel;
	
	@FindBy(css = ".zip-form #nav-zipcode")
	private WebElement headerfindZipcodetext;
	
	@FindBy(css = ".zip-form .zip-button")
	private WebElement headerFindplansbutton;
	
	@FindBy(css = ".zip-lookup")
	private WebElement headerNeedhelptext;
	
	@FindBy(css = ".zip-lookup>a")
	private WebElement headerlookupzipLink;
	
	@FindBy(css = "#subnav_2 .nav-col>a")
	private WebElement headerRequestforhelpLink;
	
	@FindBy(css = "#planTypesColumn h3:nth-of-type(1)>a")
	private WebElement headerShopLink;
	
	@FindBy(css = "#planTypesColumn h3:nth-of-type(2)>a")
	private WebElement headerEnrollLink;
	
	@FindBy(css = "#planTypesColumn h3:nth-of-type(3)>a")
	private WebElement headerResourcesLink;
	
	@FindBy(css = "#subnav_2 div[class$='content-2']>h3:nth-of-type(1)>a")
	private WebElement headerAdvantageplanLink;
	
	@FindBy(css = "#subnav_2 div[class$='content-2'] div:nth-of-type(1) a") //element
	private WebElement headerMedicaresupplementplanLink;
	
	@FindBy(css = "#subnav_2 div[class='content content-2'] h3:nth-of-type(2)>a")
	private WebElement headerPrescriptionLink;
	
	@FindBy(css = "#subnav_2 div[class='content content-2'] h3:nth-of-type(3)>a")
	private WebElement headerGetaplanrecommendationLink;
	
	@FindBy(css = "#subnav_2 div[class='content content-2'] h3:nth-of-type(4)>a")
	private WebElement headerDrugcostLink;
	
	@FindBy(css = "#subnav_2 div[class='content content-2'] h3:nth-of-type(5)>a")
	private WebElement headerPharmacysearchLink;
	
	@FindBy(css = "#subnav_2 div[class='content content-2'] h3:nth-of-type(6)>a")
	private WebElement headerProvidersearchLink;
	
	@FindBy(css = "#subnav_2 #updates-mobile-email")
	private WebElement hearderEmailtext;
	
	@FindBy(css = "#subnav_2 #updates-form .sign-up-button")
	private WebElement headerEmailsubmitButton;
	
	@FindBy(css = "#emailmobile h4")
	private WebElement headerShopForaPlanThankYou;
	
	//Learn about medicare inner element
	@FindBy(css = "#subnav_3 #medEdHome")
	private WebElement headerMedicareeducationLink;
	
	@FindBy(css = "#subnav_3 div[class$='content-1'] ul>li:nth-of-type(1)>a")
	private WebElement headerEligibilityLink;
	
	@FindBy(css = "#subnav_3 div[class$='content-1'] ul>li:nth-of-type(2)>a")
	private WebElement headerCoverageLink;
	
	@FindBy(css = "#subnav_3 div[class$='content-1'] ul>li:nth-of-type(3)>a")
	private WebElement headermedicarePrescriptionprovidersLink;
	
	@FindBy(css = "#subnav_3 div[class$='content-1'] ul>li:nth-of-type(4)>a")
	private WebElement headerCostbasicsLink;
	
	@FindBy(css = "#subnav_3 div[class$='content-2'] li:nth-of-type(1)>a")
	private WebElement headerMedicareadvantageLink;
	
	@FindBy(css = "#subnav_3 div[class$='content-2'] li:nth-of-type(2) a")
	private WebElement headerMedicaresupplemnetLink; //geo targetting
	
	@FindBy(css = "#subnav_3 div[class$='content-2'] li:nth-of-type(3)>a")
	private WebElement headerMedicareprescriptionLink;
	
	@FindBy(css = "#subnav_3 div[class$='content-3']>div ul>li a")
	private WebElement headerEnrollment;
	
	@FindBy(css = "#subnav_3 div[class$='content-3'] li:nth-of-type(1)>a")
	private WebElement headerFAQLink; //geo targetting
	
//Footer Elements
	
	@FindBy(css = "footer.footer")
	private WebElement footerSection;
	
	@FindBy(css = "ul.visitaarp.linksCond > li > a")
	private WebElement footerVisitAARPOrgLink;
	
	@FindBy(css = "#gfn_lnk_row2_1 > span")
	private WebElement footerMedicareAdvantagePlansLink;
		
	@FindBy(css = ".linksCond #gfn_lnk_row2_2 span[itemprop='name'] span:nth-child(2)") //Geotargetting
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
    
	@FindBy(css = "button#sam-call-button img")
	public WebElement footerCallbannerimage;
    
	@FindBy(css = "button#sam-call-button >div>span:nth-of-type(1)")
	public WebElement footerCallbanner;
	
	@FindBy(css = "#sam-call-modal .modal-body")
	public WebElement footerCallbannerPopup;
	
	@FindBy(css = "#sam-call-modal svg")
	public WebElement footerCallbannerPopupclose;
    
	// Landing page
	@FindBy(xpath = "//h1[contains(@class,'text-display')]")
	private WebElement landingpageHeader;
	
	
	//Shop page
	@FindBy(xpath = "//span[contains(text(),'Get Help Choosing')]")
	private WebElement HeaderShopToolsGetHelpChoosingLink;
	
//Header Element Verification Method 
	
	public void headerElementsMobile() {
		System.out.println("Validating Mobile Header Elements: ");
		validate(headerSectionmenu, 30);
		if (driver.getCurrentUrl().contains("aarpmedicare")) {
			validate(AARPlogoInHeader, 30);
			try {
				if(headerCompanyname.isDisplayed()) //only aarp and geo targetting
					System.out.println("Element found!!!!");
				Assert.assertTrue(headerCompanyname.getText().contains("UnitedHealthcare Insurance Company"));
			}
			catch(Exception e){
				System.out.println("Company name is not Visible");
			}
			
		} else if (driver.getCurrentUrl().contains("uhcmedicare")) {
			validate(UHClogoInHeader, 30);
		}
		validate(headerHeartImage, 30);
		try {
			if(headerHeartNumberofPlan.isDisplayed())
				System.out.println("Element found!!!!");
		}
		catch(Exception e){
			System.out.println("Heart count is not Visible");
		}
		waitTillElementClickableInTime(headerSectionmenu, 45);
		headerSectionmenu.click();
		if (driver.getCurrentUrl().contains("aarpmedicare")) {
			validate(headerVisitAARPOrgLink, 30); //Only AARP
			Assert.assertTrue(headerVisitAARPOrgLink.getText().contains("Visit AARP.org"));
		}
		validate(headerAlreadyAPlanMember, 30);
		Assert.assertTrue(headerAlreadyAPlanMember.getText().contains("Already a Plan Member?"));
		validate(headerAlreadyAPlanMemberPipeSymbol, 30);
		Assert.assertTrue(headerAlreadyAPlanMemberPipeSymbol.getText().contains("|"));
		validate(headerSigninLink, 30);
		Assert.assertTrue(headerSigninLink.getText().contains("Sign in"));
		validate(headerRegisterLink, 30);
		Assert.assertTrue(headerRegisterLink.getText().contains("Register"));
		validate(hedearmenuLogo, 30);
		validate(hedearmenuSearchbox, 30);
		validate(hedearmenuSearchicon, 30);
		validate(shopforaplanLink, 30);
		shopforaplanLink.click();
		validate(headernavigationBackbutton, 30);
		headernavigationBackbutton.click();
		validate(learnaboutmedicareLink, 30);
		validate(headernavigationCloseicon, 30);
		headernavigationCloseicon.click();
		validate(headerSectionmenu, 30);
		//validating shop for plan sub links
		headerSectionmenu.click();
		shopforaplanLink.click();
		validate(headerFindplanslabel, 30);
		validate(headerfindZipcodetext, 30);
		validate(headerFindplansbutton, 30);
		validate(headerNeedhelptext, 30);
		validate(headerlookupzipLink, 30);
		validate(headerRequestforhelpLink, 30);
		validate(headerShopLink, 30);
		Assert.assertTrue(headerShopLink.getText().contains("Shop"));
		validate(headerEnrollLink, 30);
		Assert.assertTrue(headerEnrollLink.getText().contains("Enroll"));
		validate(headerResourcesLink, 30);
		Assert.assertTrue(headerResourcesLink.getText().contains("Resources"));
		validate(headerAdvantageplanLink, 30);
		Assert.assertTrue(headerAdvantageplanLink.getText().contains("Medicare Advantage Plans"));
		validate(headerMedicaresupplementplanLink, 20);
		Assert.assertTrue(headerMedicaresupplementplanLink.getText().contains("Medicare Supplement Plans"));
		validate(headerPrescriptionLink, 30);
		Assert.assertTrue(headerPrescriptionLink.getText().contains("Medicare Prescription Drug Plans"));
		validate(headerGetaplanrecommendationLink, 30);
		Assert.assertTrue(headerGetaplanrecommendationLink.getText().contains("Get a Plan Recommendation"));
		validate(headerDrugcostLink, 30);
		Assert.assertTrue(headerDrugcostLink.getText().contains("Drug Cost Estimator"));
		validate(headerPharmacysearchLink, 30);
		Assert.assertTrue(headerPharmacysearchLink.getText().contains("Pharmacy Search"));
		validate(headerProvidersearchLink, 30);
		Assert.assertTrue(headerProvidersearchLink.getText().contains("Provider Search"));
		validate(hearderEmailtext, 30);
		validate(headerEmailsubmitButton, 30);
		headernavigationBackbutton.click();
		// Learn about medicare inner elements
		if (driver.getCurrentUrl().contains("aarpmedicare"))
			AARPlogoInHeader.click();
		else
			UHClogoInHeader.click();
		pageloadcomplete();
		navigatePRELandingpageMobile();
		headerSectionmenu.click();
		learnaboutmedicareLink.click();
		validate(headerMedicareeducationLink, 30);
		Assert.assertTrue(headerMedicareeducationLink.getText().contains("Medicare Education Home"));
		validate(headerEligibilityLink, 30);
		Assert.assertTrue(headerEligibilityLink.getText().contains("Eligibility"));
		validate(headerCoverageLink, 30);
		Assert.assertTrue(headerCoverageLink.getText().contains("Coverage Choices"));
		validate(headermedicarePrescriptionprovidersLink, 30);
		Assert.assertTrue(headermedicarePrescriptionprovidersLink.getText().contains("Providers"));
		validate(headerCostbasicsLink, 30);
		Assert.assertTrue(headerCostbasicsLink.getText().contains("Medicare Cost Basics"));
		validate(headerMedicareadvantageLink, 30);
		Assert.assertTrue(headerMedicareadvantageLink.getText().contains("Medicare Advantage Plans"));
		try {
			if(headerMedicaresupplemnetLink.isDisplayed())
				Assert.assertTrue(headerMedicaresupplemnetLink.getText().contains("Medicare Supplement Insurance Plans"));
			}catch(Exception e){
				System.out.println("Medicare Supplement Insurance Plans link is not on header available for selected geo location");
			}
		validate(headerMedicareprescriptionLink, 30);
		Assert.assertTrue(headerMedicareprescriptionLink.getText().contains("Medicare Prescription Drug Plans"));
		validate(headerEnrollment, 30);
		Assert.assertTrue(headerEnrollment.getText().contains("Enrollment Basics"));
		try {
		if(headerFAQLink.isDisplayed())
			Assert.assertTrue(headerFAQLink.getText().contains("Medicare FAQ"));
		}catch(Exception e){
			System.out.println("MedicareFAQ link is not available on header for selected geo location");
		}
		headernavigationmedicareBackbutton.click();
		validate(learnaboutmedicareLink, 30);
		validate(headernavigationCloseicon, 30);
		headernavigationCloseicon.click();
	}
	
	// Footer Element Verification Method
	public void footerElementsMobile() {
		System.out.println("Validating Mobile Footer Elements: ");
		mobileswipe("95%", 6,true);
		validate(footerSection, 30);
		validate(footerVisitAARPOrgLink, 30);//only aarp
		Assert.assertTrue(footerVisitAARPOrgLink.getText().contains("Visit AARP.org"));
		validate(footerMedicareAdvantagePlansLink, 30);
		Assert.assertTrue(footerMedicareAdvantagePlansLink.getText().contains("Medicare Advantage Plans"));
		try {
			validate(footerMedicareSupplementInsurancePlansLink,30);
			if (footerMedicareSupplementInsurancePlansLink.isDisplayed())
				Assert.assertTrue(footerMedicareSupplementInsurancePlansLink.getText()
						.contains("Medicare Supplement Insurance Plans"));
		} catch (Exception e) {
			System.out.println(
					"Medicare Supplement Insurance Plans link is not available on footer for selected geo location");
		}
		validate(footerMedicarePrescriptionDrugPlansLink, 30);
		Assert.assertTrue(
				footerMedicarePrescriptionDrugPlansLink.getText().contains("Medicare Prescription Drug Plans"));
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
		validate(footerCallbannerimage, 30);
		validate(footerCallbanner, 30);
		Assert.assertTrue(footerCallbanner.getText().contains("Call a Licensed Insurance Agent"));
	}

	// Navigating Plan RecommendationEngine via Shop for a plan -->Shop-->Tools-->Get Help Choosing
	public void navigationToPREViaShopToolsMobile() {
		validate(headerSectionmenu, 30);
		headerSectionmenu.click();
		validate(shopforaplanLink, 30);
		shopforaplanLink.click();
		validate(headerShopLink, 30);
		headerShopLink.click();
		validate(HeaderShopToolsGetHelpChoosingLink, 30);
		HeaderShopToolsGetHelpChoosingLink.click();
		validate(landingpageHeader, 30);
		Assert.assertTrue(landingpageHeader.getText().contains("insurance plan"));
	}

	// ZipCode Function inside Shop for a Plan Mobile
	public void zipcodeFunctionInShopforaplanHeaderMobile(String zipcode) {
		validate(headerSectionmenu, 30);
		headerSectionmenu.click();
		validate(shopforaplanLink, 30);
		shopforaplanLink.click();
		validate(headerfindZipcodetext, 30);
		validate(headerFindplansbutton, 30);
		headerfindZipcodetext.sendKeys(zipcode);
		headerFindplansbutton.click();
		validateLinks("/plan-summary||zipcode");
		browserBack();
	}

	// Email Function inside Shop for a Plan Mobile
	public void emailFunctionInShopforaplanMobile(String email) {
		if (driver.getCurrentUrl().contains("aarpmedicare")) {
			validate(AARPlogoInHeader, 30);
			AARPlogoInHeader.click();
		} else if (driver.getCurrentUrl().contains("uhcmedicare")) {
			validate(UHClogoInHeader, 30);
			UHClogoInHeader.click();
		}
		//Validating functionality from home page coz different page give different results
		validate(headerSectionmenu, 30);
		headerSectionmenu.click();
		validate(shopforaplanLink, 30);
		shopforaplanLink.click();
		mobileswipe("95%",2,true);
		validate(hearderEmailtext, 30);
		hearderEmailtext.click();
		hearderEmailtext.sendKeys(email);
		hidekeypad();
		headerEmailsubmitButton.click();
		validate(headerShopForaPlanThankYou, 30);
		mobileswipe("90%",2,false);
		headernavigationBackbutton.click();
		validate(learnaboutmedicareLink, 30);
		validate(headernavigationCloseicon, 30);
		headernavigationCloseicon.click();
	}
		
	// Enter Search Key Function in Navigation bar mobile
	public void enterSearchFunctionHeaderMobile(String SearchKey) {
		browserRefresh();
		validate(headerSectionmenu, 30);
		String actualpageurl = driver.getCurrentUrl();
		System.out.println("Actual Page is :"+actualpageurl);
		headerSectionmenu.click();
		hedearmenuSearchbox.click();
		hedearmenuSearchbox.sendKeys(SearchKey);
		hedearmenuSearchicon.click();
		String ExpectedPage = "/search?q1=";
		validateLinks(ExpectedPage);
		browserBack();
	}
		
	// Back to Top Function in Footer mobile
	public void backtoTopFunctionMobile() {
		browserRefresh();
		navigatePRELandingpageMobile();
		mobileswipe("85%",4,true);
		waitforElementVisibilityInTime(footerBackToTopLink, 45);
		mobileactiontab(footerBackToTopLink);
		String actualpageurl = driver.getCurrentUrl();
		if (actualpageurl.contains("aarpmedicare")) {
			validate(AARPlogoInHeader, 30);
			AARPlogoInHeader.isSelected();
			AARPlogoInHeader.click();
		} else if (actualpageurl.contains("uhcmedicare")) {
			validate(UHClogoInHeader, 30);
			UHClogoInHeader.isSelected();
			UHClogoInHeader.click();
		}
	}
	
	public void backtoshopforaplan(boolean back) {
		if(back) {
			if (driver.getCurrentUrl().contains("aarpmedicare")) {
				validate(AARPlogoInHeader, 30);
				AARPlogoInHeader.click();
			} else if (driver.getCurrentUrl().contains("uhcmedicare")) {
				validate(UHClogoInHeader, 30);
				UHClogoInHeader.click();
			}
		}
		else
			browserBack();
		validate(headerSectionmenu, 30);
		headerSectionmenu.click();
		validate(shopforaplanLink, 30);
		shopforaplanLink.click();
	}

	public void backtolearnmoremodicare(boolean back) {
		if(back)
			browserBack();
		validate(headerSectionmenu, 30);
		headerSectionmenu.click();
		validate(learnaboutmedicareLink, 30);
		learnaboutmedicareLink.click();
	}
	
	public void headerLinkvalidationMobile() {
		String curURL = driver.getCurrentUrl();
		
		menuclick();
		headerSigninLink.click();
		if (curURL.contains("aarpmedicare"))
			validateLinks("medicare.uhc.com/aarp");
		else
			validateLinks("medicare.uhc.com");
		
		browserBack();
		menuclick();
		headerRegisterLink.click();
		validateLinks("healthsafe-id.com/register/personalInfo||protected/mdm/challenge");
		
		if (curURL.contains("aarpmedicare")) {
		browserBack();
		menuclick();
		//another window - only aarp
		navigatesubLink(headerVisitAARPOrgLink.getAttribute("href"));
		validateLinksanotherWindowmobile("/health/medicare-insurance/?intcmp");
		}
		
		backtoshopforaplan(false);
		headerlookupzipLink.click();
		validateLinks("/health-plans.html?lookupZipcode");
		backtoshopforaplan(true);
		headerRequestforhelpLink.click();
		validateLinks("health-plans/shop/connect");
		backtoshopforaplan(true);
		headerShopLink.click();
		validateLinks("/health-plans/shop.html");
		backtoshopforaplan(true);
		headerEnrollLink.click();
		validateLinks("/health-plans/enroll.html");
		backtoshopforaplan(true);
		headerResourcesLink.click();
		validateLinks("/health-plans/resources.html");
		backtoshopforaplan(true);
		mobileswipe("90%",true);
		headerAdvantageplanLink.click();
		validateLinks("/health-plans/shop/medicare-advantage-plans.html");
		backtoshopforaplan(true);
		mobileswipe("90%",true);
		headerMedicaresupplementplanLink.click();
		validateLinks("/health-plans/shop/medicare-supplement-plans.html||health-plans.html?product=");
		backtoshopforaplan(true);
		mobileswipe("90%",true);
		headerPrescriptionLink.click();
		validateLinks("/health-plans/shop/prescription-drug-plans.html");
		backtoshopforaplan(true);
		mobileswipe("90%",true);
		headerGetaplanrecommendationLink.click();
		validateLinks("/plan-recommendation-engine.html");
		backtoshopforaplan(true);
		mobileswipe("90%",true);
		headerDrugcostLink.click();
		validateLinks("health-plans/estimate-drug-costs.html");
		backtoshopforaplan(true);
		mobileswipe("90%",true);
		headerPharmacysearchLink.click();
		validateLinks("/health-plans/aarp-pharmacy.html");

		// Opens in another window
		backtoshopforaplan(true);
		mobileswipe("90%",true);
		validate(headerProvidersearchLink,30);
		driver.navigate().refresh();
		
		// Learn about medicare inner elements
		backtolearnmoremodicare(true);
		headerMedicareeducationLink.click(); // Only in mobile
		validateLinks("/medicare-education.html");
		backtolearnmoremodicare(true);
		headerEligibilityLink.click();
		validateLinks("/medicare-education/medicare-eligibility.html");
		backtolearnmoremodicare(true);
		headerCoverageLink.click();
		validateLinks("/medicare-education/medicare-parts-and-medigap-plans.html");
		backtolearnmoremodicare(true);
		headermedicarePrescriptionprovidersLink.click();
		validateLinks("/medicare-education/medicare-benefits.html");
		backtolearnmoremodicare(true);
		headerCostbasicsLink.click();
		validateLinks("/medicare-education/medicare-costs.html");
		backtolearnmoremodicare(true);
		mobileswipe("80%",true);
		headerMedicareadvantageLink.click();
		validateLinks("/medicare-education/medicare-advantage-plans.html");
		
		backtolearnmoremodicare(true);
		mobileswipe("80%",true);
		try {
		validate(headerMedicaresupplemnetLink,30);
		headerMedicaresupplemnetLink.click(); //geotargetting
		validateLinks("/medicare-education/medicare-supplement-plans.html");
		}catch(Exception e) {
			System.out.println("Geo targetting link 'Medicare Supplement Insurance Plans' is not available");
			driver.navigate().refresh();
		}
		backtolearnmoremodicare(true);
		mobileswipe("90%",true);
		headerMedicareprescriptionLink.click();
		validateLinks("/medicare-education/medicare-part-d.html");
		backtolearnmoremodicare(true);
		mobileswipe("90%",true);
		validate(headerEnrollment,30);
		navigatesubLink(headerEnrollment.getAttribute("href"));
		validateLinks("/medicare-education/enrollment-and-changing-plans.html");
		backtolearnmoremodicare(true);
		mobileswipe("90%",true);
		try {
		validate(headerFAQLink,30);//geotargetting
		navigatesubLink(headerFAQLink.getAttribute("href"));
		validateLinks("/medicare-education/medicare-faq.html");
		}catch(Exception e) {
			System.out.println("Geo targetting link 'Medicare FAQ' is not available");
			driver.navigate().refresh();
		}
	}
	
	public void footerLinkvalidationMobile() {
		if (driver.getCurrentUrl().contains("aarpmedicare")) {
			validate(AARPlogoInHeader, 30);
			AARPlogoInHeader.click();
		} else if (driver.getCurrentUrl().contains("uhcmedicare")) {
			validate(UHClogoInHeader, 30);
			UHClogoInHeader.click();
		}
		String curURL = driver.getCurrentUrl();
		navigatePRELandingpageMobile();
		mobileswipe("80%",4,true);
		if (curURL.contains("aarpmedicare")) {
			//another window - only aarp
			navigatesubLink(footerVisitAARPOrgLink.getAttribute("href"));
			threadsleep(1500);
			validateLinksanotherWindowmobile("/health/medicare-insurance/?intcmp");
			}
		
		footerMedicareAdvantagePlansLink.click();
		validateLinks("/health-plans/shop/medicare-advantage-plans");
		browserBack();
		//mobileswipe("80%",3,true);
		validate(footerMedicareSupplementInsurancePlansLink,30);
		//footerMedicareSupplementInsurancePlansLink.click();
		mobileactiontab(footerMedicareSupplementInsurancePlansLink);
		validateLinks("/health-plans/shop/medicare-supplement-plans.html||health-plans.html?product=");
		browserBack();
		
		//mobileswipe("80%",3,true);
		footerMedicarePrescriptionDrugPlansLink.click();
		validateLinks("/health-plans/shop/prescription-drug-plans");
		browserBack();
		mobileswipe("80%",true);
		footerMedicareEducationLink.click();
		validateLinks("/medicare-education.html");
		browserBack();
		//mobileswipe("80%",3,true);
		footerHomeLink.click();
		Assert.assertTrue(driver.getCurrentUrl().equals(curURL));
		navigatePRELandingpageMobile();
		mobileswipe("80%",4,true);
		footerAboutUsLink.click();
		validateLinks("/about-us.html");
		browserBack();
		//mobileswipe("80%",3,true);
		footerContactUsLink.click();
		validateLinks("/contact-us.html");
		browserBack();
		//mobileswipe("80%",3,true);
		footerSiteMapLink.click();
		validateLinks("/sitemap.html");
		browserBack();
		//mobileswipe("80%",3,true);
		footerPrivacyPolicyLink.click();
		validateLinks("/privacy_policy.html");
		browserBack();
		//mobileswipe("80%",3,true);
		footerTermsofUseLink.click();
		validateLinks("/terms-of-use.html");
		browserBack();
		//mobileswipe("80%",3,true);
		footerDisclaimersLink.click();
		validateLinks("/disclaimer.html");
		browserBack();
		//mobileswipe("80%",3,true);
		footerAgentsBrokersLink.click();
		validateLinks("/health-insurance-brokers.html");
		browserBack();
		//mobileswipe("80%",3,true);
		if (curURL.contains("uhcmedicare")) {
		footerAccessibilityLink.click();
		validateLinks("/legal/accessibility");
		browserBack();
		}
		else {
			validate(footerAccessibilityLink,30);
		}
		//mobileswipe("80%",3,true);
		footerCallbannerimage.click();
		validate(footerCallbannerPopup,30);
		footerCallbannerPopupclose.click();		
	}
	
	public void validateLinks(String expURL) {
		pageloadcomplete();
		String curURL = driver.getCurrentUrl();
		threadsleep(3000);
		if(expURL.contains("||") && curURL.contains(expURL.split("\\|\\|")[0]) || expURL.contains("||") && curURL.contains(expURL.split("\\|\\|")[1])){
			System.out.println("Link validation True");
		}
		else if(curURL.contains(expURL)) {
			System.out.println("Link validation True");
		}
		else {
			System.out.println("Link validation False");
			System.out.println("Expected URL "+expURL);
			System.out.println("Actual URL "+curURL);
			Assert.assertTrue(false);
		}
	}
	
	public void menuclick() {
		validate(headerSectionmenu, 30);
		headerSectionmenu.click();
	}
	
	public void navigatePRELandingpageMobile() {
		validate(headerSectionmenu, 30);
		headerSectionmenu.click();
		validate(shopforaplanLink, 30);
		shopforaplanLink.click();
		mobileswipe("90%",true);
		validate(headerGetaplanrecommendationLink, 30);
		mobileactiontab(headerGetaplanrecommendationLink);
		validate(landingpageHeader, 30);
		Assert.assertTrue(landingpageHeader.getText().contains("insurance plan"));
	}
	
	public void browserBack() {
		driver.navigate().back();
		threadsleep(1000);
	}

	public void navigatesubLink(String subURL) {
		driver.navigate().to(subURL);
		threadsleep(1000);
		pageloadcomplete();
	}

	public void validateLinksanotherWindowmobile(String expURL) {
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		if (windows.size() == 2) {
			System.out.println(driver.getCurrentUrl());
			driver.switchTo().window("CDwindow-1");
			threadsleep(1000);
			validateLinks(expURL);
			driver.close();
			System.out.println(driver.getCurrentUrl());
			driver.switchTo().window("CDwindow-0");
			threadsleep(1000);
		} else {
			System.out.println("Link validation fails in popup window" + expURL);
			driver.switchTo().window("CDwindow-0");
			threadsleep(1000);
			Assert.assertTrue(false);
		}
	}

	public void browserRefresh() {
		driver.navigate().refresh();
		threadsleep(1000);
		pageloadcomplete();
	}

}

