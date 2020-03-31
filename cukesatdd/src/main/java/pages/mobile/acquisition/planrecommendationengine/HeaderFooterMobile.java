/**
 * 
 */
package pages.mobile.acquisition.planrecommendationengine;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import atdd.framework.UhcDriver;

public class HeaderFooterMobile extends UhcDriver {

	public HeaderFooterMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);

	// Header Elements
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

	// Header Menu Elements
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

	@FindBy(css = "#subnav_2 div[class$='content-2'] div:nth-of-type(1) a") // element
	private WebElement headerMedicaresupplementplanLink;

	@FindBy(css = "#subnav_2 div[class='content content-2'] h3:nth-of-type(2)>a")
	private WebElement headerPrescriptionLink;

	//@FindBy(css = "#subnav_2 div[class='content content-2'] h3:nth-of-type(3)>a")
	@FindBy(linkText = "Get a Plan Recommendation")
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

	// Learn about medicare inner element
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
	private WebElement headerMedicaresupplemnetLink; // geo targetting

	@FindBy(css = "#subnav_3 div[class$='content-2'] li:nth-of-type(3)>a")
	private WebElement headerMedicareprescriptionLink;

	@FindBy(css = "#subnav_3 div[class$='content-3']>div ul>li a")
	private WebElement headerEnrollment;

	@FindBy(css = "#subnav_3 div[class$='content-3'] li:nth-of-type(1)>a")
	private WebElement headerFAQLink; // geo targetting

	//Footer Elements
	@FindBy(css = "footer.footer")
	private WebElement footerSection;

	@FindBy(css = "div.sam")
	public WebElement footerCallbannerSection;

	@FindBy(css = "ul.visitaarp.linksCond > li > a")
	private WebElement footerVisitAARPOrgLink;

	@FindBy(css = "#gfn_lnk_row2_1 > span")
	private WebElement footerMedicareAdvantagePlansLink;

	@FindBy(css = ".linksCond #gfn_lnk_row2_2 span[itemprop='name'] span:nth-child(2)") // Geotargetting
	private WebElement footerMedicareSupplementInsurancePlansLink;

	@FindBy(css = "#gfn_lnk_row2_4 > span")
	private WebElement footerMedicarePrescriptionDrugPlansLink;

	@FindBy(css = "#gfn_lnk_row3_1 > span")
	public WebElement footerMedicareEducationLink;

	@FindBy(css = ".footer-top>ul>li>a.back-to-top")
	public WebElement footerBackToTopLink;

	@FindBy(css = "#stateWidget > div > label")
	public WebElement footerYourState;

	@FindBy(css = "a#gf_lnk_1")
	public WebElement footerHomeLink;

	@FindBy(css = "a#gf_lnk_2")
	public WebElement footerAboutUsLink;

	@FindBy(css = "a#gf_lnk_3")
	public WebElement footerContactUsLink;

	@FindBy(css = "a#gf_lnk_4")
	public WebElement footerSiteMapLink;

	@FindBy(css = "a#gf_lnk_5")
	public WebElement footerPrivacyPolicyLink;

	@FindBy(css = "a#gf_lnk_6")
	public WebElement footerTermsofUseLink;

	@FindBy(css = "a#gf_lnk_7")
	public WebElement footerDisclaimersLink;

	@FindBy(css = "a#gf_lnk_8")
	public WebElement footerAgentsBrokersLink;

	@FindBy(css = "a#gf_lnk_9")
	public WebElement footerAccessibilityLink;

	@FindBy(css = ".footer-middle>p:nth-of-type(1)")
	public WebElement footerCertificateStatement;

	@FindBy(css = ".footer-middle>p:nth-of-type(2)")
	public WebElement footerLastUpdated;

	@FindBy(css = "#sam-call-button")
	public WebElement footerCallbannerimage;

	@FindBy(css = "button#sam-call-button >div>span:nth-of-type(1)")
	public WebElement footerCallbanner;

	@FindBy(css = "#sam-call-modal .modal-body")
	public WebElement footerCallbannerPopup;

	@FindBy(css = "#sam-call-modal svg")
	public WebElement footerCallbannerPopupclose;

	// Landing page
	@FindBy(css = "h1[class^='text-display']")
	private WebElement landingpageHeader;

	// Shop page
	@FindBy(css = "a.card-link__link[dtmname*='Get Help']")
	private WebElement HeaderShopToolsGetHelpChoosingLink;

	// Header Element Verification Method
	public void headerElementsMobile() {
		// Works only for Android due to prod issue in iphoneX
		System.out.println("Validating Mobile Header Elements");
		validate(headerSectionmenu, 30);
		if (driver.getCurrentUrl().contains("aarpmedicare")) {
			validate(AARPlogoInHeader, 30);
			try {
				if (headerCompanyname.isDisplayed()) // only aarp and geo targetting
					System.out.println("Element found!!!!");
				Assert.assertTrue(headerCompanyname.getText().contains("UnitedHealthcare Insurance Company"));
			} catch (Exception e) {
				System.out.println("Company name is not Visible");
			}

		} else if (driver.getCurrentUrl().contains("uhcmedicare")) {
			validate(UHClogoInHeader, 30);
		}
		validate(headerHeartImage, 30);
		try {
			if (headerHeartNumberofPlan.isDisplayed())
				System.out.println("Element found!!!!");
		} catch (Exception e) {
			System.out.println("Heart count is not Visible");
		}
		waitTillElementClickableInTime(headerSectionmenu, 45);
		headerSectionmenu.click();
		if (driver.getCurrentUrl().contains("aarpmedicare")) {
			validate(headerVisitAARPOrgLink, 30); // Only AARP
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
		// validating shop for plan sub links
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
		mobileswipe("50%", 1, true);
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
		mobileswipe("90%", 1, false);
		headernavigationBackbutton.click();
		headernavigationCloseicon.click();
		// Learn about medicare inner elements
		if (driver.getCurrentUrl().contains("aarpmedicare"))
			AARPlogoInHeader.click();
		else
			UHClogoInHeader.click();
		pageloadcomplete();
		navigatePRELandingpageMobile();
		pageloadcomplete();

		// We have prod issue in PRE hence not validating the same

//		headerSectionmenu.click();
//		learnaboutmedicareLink.click();
//		validate(headerMedicareeducationLink, 30);
//		Assert.assertTrue(headerMedicareeducationLink.getText().contains("Medicare Education Home"));
//		validate(headerEligibilityLink, 30);
//		Assert.assertTrue(headerEligibilityLink.getText().contains("Eligibility"));
//		validate(headerCoverageLink, 30);
//		Assert.assertTrue(headerCoverageLink.getText().contains("Coverage Choices"));
//		validate(headermedicarePrescriptionprovidersLink, 30);
//		Assert.assertTrue(headermedicarePrescriptionprovidersLink.getText().contains("Providers"));
//		validate(headerCostbasicsLink, 30);
//		Assert.assertTrue(headerCostbasicsLink.getText().contains("Medicare Cost Basics"));
//		validate(headerMedicareadvantageLink, 30);
//		Assert.assertTrue(headerMedicareadvantageLink.getText().contains("Medicare Advantage Plans"));
//		try {
//			if(headerMedicaresupplemnetLink.isDisplayed())
//				Assert.assertTrue(headerMedicaresupplemnetLink.getText().contains("Medicare Supplement Insurance Plans"));
//			}catch(Exception e){
//				System.out.println("Medicare Supplement Insurance Plans link is not on header available for selected geo location");
//			}
//		validate(headerMedicareprescriptionLink, 30);
//		Assert.assertTrue(headerMedicareprescriptionLink.getText().contains("Medicare Prescription Drug Plans"));
//		validate(headerEnrollment, 30);
//		Assert.assertTrue(headerEnrollment.getText().contains("Enrollment Basics"));
//		try {
//		if(headerFAQLink.isDisplayed())
//			Assert.assertTrue(headerFAQLink.getText().contains("Medicare FAQ"));
//		}catch(Exception e){
//			System.out.println("MedicareFAQ link is not available on header for selected geo location");
//		}
//		headernavigationmedicareBackbutton.click();
//		validate(learnaboutmedicareLink, 30);
//		validate(headernavigationCloseicon, 30);
//		headernavigationCloseicon.click();
	}

	// Footer Element Verification Method
	public void footerElementsMobile() {
		System.out.println("Validating Mobile Footer Elements: ");

		mobileUtils.mobileFindElementBeforeCallBanner(footerSection, "50%", 5, true);

		validate(footerSection, 30);
		validate(footerVisitAARPOrgLink, 30);// only aarp
		Assert.assertTrue(footerVisitAARPOrgLink.getText().contains("Visit AARP.org"));
		validate(footerMedicareAdvantagePlansLink, 30);
		Assert.assertTrue(footerMedicareAdvantagePlansLink.getText().contains("Medicare Advantage Plans"));
		try {
			validate(footerMedicareSupplementInsurancePlansLink, 30);
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

	// Navigating Plan RecommendationEngine via Shop for a plan
	// -->Shop-->Tools-->Get Help Choosing
	public void navigationToPREViaShopToolsMobile() {
		validate(headerSectionmenu, 30);
		headerSectionmenu.click();
		validate(shopforaplanLink, 30);
		shopforaplanLink.click();
		validate(headerShopLink, 30);
		headerShopLink.click();
		mobileUtils.mobileLocateElement(HeaderShopToolsGetHelpChoosingLink);
		navigatesubLink(HeaderShopToolsGetHelpChoosingLink.getAttribute("href"));
		// mobileUtils.mobileLocateElementClick(HeaderShopToolsGetHelpChoosingLink);
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
		// Validating functionality from home page coz different page give different
		// results
		validate(headerSectionmenu, 30);
		headerSectionmenu.click();
		validate(shopforaplanLink, 30);
		shopforaplanLink.click();
		mobileUtils.mobileFindElementBeforeCallBanner(hearderEmailtext, "50%", 5, true);
		validate(hearderEmailtext, 30);
		hearderEmailtext.click();
		hearderEmailtext.sendKeys(email);
		hidekeypad();
		mobileUtils.mobileFindElementBeforeCallBanner(hearderEmailtext, "50%", 1, true);
		headerEmailsubmitButton.click();
		validate(headerShopForaPlanThankYou, 30);
		mobileswipe("90%", 2, false);
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
		System.out.println("Actual Page is :" + actualpageurl);
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
		mobileUtils.mobileFindElementBeforeCallBanner(footerBackToTopLink, "50%", 5, true);
		mobileactiontab(footerBackToTopLink);
		String actualpageurl = driver.getCurrentUrl();
		if (actualpageurl.contains("aarpmedicare")) {
			validate(AARPlogoInHeader, 30);
			AARPlogoInHeader.equals(driver.switchTo().activeElement());
			AARPlogoInHeader.click();
		} else if (actualpageurl.contains("uhcmedicare")) {
			validate(UHClogoInHeader, 30);
			UHClogoInHeader.equals(driver.switchTo().activeElement());
			UHClogoInHeader.click();
		}
	}

	public void backtoshopforaplan(boolean back) {
		if (back) {
//			if (driver.getCurrentUrl().contains("aarpmedicare")) {
//				validate(AARPlogoInHeader, 30);
//				AARPlogoInHeader.click();
//			} else if (driver.getCurrentUrl().contains("uhcmedicare")) {
//				validate(UHClogoInHeader, 30);
//				UHClogoInHeader.click();
//			}
		} else
			browserBack();
		validate(headerSectionmenu, 30);
		headerSectionmenu.click();
		validate(shopforaplanLink, 30);
		shopforaplanLink.click();
	}

	public void backtolearnmoremodicare(boolean back) {
		if (back)
			browserBack();
		validate(headerSectionmenu, 30);
		headerSectionmenu.click();
		validate(learnaboutmedicareLink, 30);
		learnaboutmedicareLink.click();
	}

	public void headerLinkvalidationMobile() {
		System.out.println("Header Links Validation");
		String curURL = driver.getCurrentUrl();
		String curWindow;
		menuclick();
		headerSigninLink.click();
		mobileUtils.fixPrivateConnectionMobile();
		if (curURL.contains("aarpmedicare"))
			validateLinks("medicare.uhc.com/aarp");
		else
			validateLinks("medicare.uhc.com");
		browserBack();
		menuclick();
		headerRegisterLink.click();
		mobileUtils.fixPrivateConnectionMobile();
		validateLinks("healthsafe-id.com/register/personalInfo||protected/mdm/challenge");

		if (curURL.contains("aarpmedicare")) {
			browserBack();
			menuclick();
			// another window - only aarp
			// navigatesubLink(headerVisitAARPOrgLink.getAttribute("href"));
			validate(headerVisitAARPOrgLink, 30);
			curWindow = driver.getWindowHandle();
			headerVisitAARPOrgLink.click();
			validateLinksanotherWindowmobile("/health/medicare-insurance/?intcmp", curWindow);
		}

		if (curURL.contains("aarpmedicare"))
			shopforaplanLink.click();
		else
			backtoshopforaplan(false);

		headerlookupzipLink.click();
		validateLinks("/health-plans.html?lookupZipcode");
		backtoshopforaplan(false);
		headerRequestforhelpLink.click();
		validateLinks("health-plans/shop/connect");
		backtoshopforaplan(false);
		headerShopLink.click();
		validateLinks("/health-plans/shop.html");
		backtoshopforaplan(false);
		mobileswipe("50%", true);
		headerEnrollLink.click();
		validateLinks("/health-plans/enroll.html");
		backtoshopforaplan(false);
		mobileswipe("50%", true);
		headerResourcesLink.click();
		validateLinks("/health-plans/resources.html");
		backtoshopforaplan(false);
		mobileswipe("90%", true);
		headerAdvantageplanLink.click();
		validateLinks("/health-plans/shop/medicare-advantage-plans.html");
		backtoshopforaplan(false);
		mobileswipe("90%", true);
		headerMedicaresupplementplanLink.click();
		validateLinks("/health-plans/shop/medicare-supplement-plans.html||health-plans.html?product=");
		backtoshopforaplan(false);
		mobileswipe("90%", true);
		headerPrescriptionLink.click();
		validateLinks("/health-plans/shop/prescription-drug-plans.html");
		backtoshopforaplan(false);
		mobileswipe("90%", true);
		headerGetaplanrecommendationLink.click();
		validateLinks("/plan-recommendation-engine.html");
		backtoshopforaplan(false);
		mobileswipe("90%", true);
		headerDrugcostLink.click();
		validateLinks("health-plans/estimate-drug-costs.html");
		backtoshopforaplan(false);
		mobileswipe("90%", true);
		headerPharmacysearchLink.click();
		validateLinks("/health-plans/aarp-pharmacy.html");

		// Opens in another window
		backtoshopforaplan(false);
		mobileswipe("90%", true);
		validate(headerProvidersearchLink, 30);
		curWindow = driver.getWindowHandle();
		headerProvidersearchLink.click();
		validateLinksanotherWindowmobile("/county-plan-selection/uhc.mnr/zip?", curWindow);
		driver.navigate().refresh();

		// We have prod issue in PRE hence not validating the same

		// Learn about medicare inner elements
//		backtolearnmoremodicare(true);
//		headerMedicareeducationLink.click(); // Only in mobile
//		validateLinks("/medicare-education.html");
//		backtolearnmoremodicare(true);
//		headerEligibilityLink.click();
//		validateLinks("/medicare-education/medicare-eligibility.html");
//		backtolearnmoremodicare(true);
//		headerCoverageLink.click();
//		validateLinks("/medicare-education/medicare-parts-and-medigap-plans.html");
//		backtolearnmoremodicare(true);
//		headermedicarePrescriptionprovidersLink.click();
//		validateLinks("/medicare-education/medicare-benefits.html");
//		backtolearnmoremodicare(true);
//		headerCostbasicsLink.click();
//		validateLinks("/medicare-education/medicare-costs.html");
//		backtolearnmoremodicare(true);
//		mobileswipe("80%",true);
//		headerMedicareadvantageLink.click();
//		validateLinks("/medicare-education/medicare-advantage-plans.html");
//		
//		backtolearnmoremodicare(true);
//		mobileswipe("80%",true);
//		try {
//		validate(headerMedicaresupplemnetLink,30);
//		headerMedicaresupplemnetLink.click(); //geotargetting
//		validateLinks("/medicare-education/medicare-supplement-plans.html");
//		}catch(Exception e) {
//			System.out.println("Geo targetting link 'Medicare Supplement Insurance Plans' is not available");
//			driver.navigate().refresh();
//		}
//		backtolearnmoremodicare(true);
//		mobileswipe("90%",true);
//		headerMedicareprescriptionLink.click();
//		validateLinks("/medicare-education/medicare-part-d.html");
//		backtolearnmoremodicare(true);
//		mobileswipe("90%",true);
//		validate(headerEnrollment,30);
//		navigatesubLink(headerEnrollment.getAttribute("href"));
//		validateLinks("/medicare-education/enrollment-and-changing-plans.html");
//		backtolearnmoremodicare(true);
//		mobileswipe("90%",true);
//		try {
//		validate(headerFAQLink,30);//geotargetting
//		navigatesubLink(headerFAQLink.getAttribute("href"));
//		validateLinks("/medicare-education/medicare-faq.html");
//		}catch(Exception e) {
//			System.out.println("Geo targetting link 'Medicare FAQ' is not available");
//			driver.navigate().refresh();
//		}
	}

	public void footerLinkvalidationMobile() {
		System.out.println("Footer Links Validation");
		String curURL = driver.getCurrentUrl();
		String curWindow;
		validate(footerCallbannerimage, 30);
		footerCallbannerimage.click();
		validate(footerCallbannerPopup, 30);
		validate(footerCallbannerPopupclose, 30);
		footerCallbannerPopupclose.click();
		System.out.println("Footerbanner Clicked");

		if (curURL.contains("aarpmedicare")) {
			curWindow = driver.getWindowHandle();
			// another window - only aarp
			if (driver.getClass().toString().toUpperCase().contains("ANDROID")) {
				mobileUtils.mobileLocateElementClick(footerVisitAARPOrgLink);
				validateLinksanotherWindowmobile("/health/medicare-insurance/?intcmp", curWindow);
			} else {
				navigatesubLink(footerVisitAARPOrgLink.getAttribute("href"));
				browserBack();
			}
		}
		mobileUtils.mobileLocateElementClick(footerMedicareAdvantagePlansLink);
		validateLinks("/health-plans/shop/medicare-advantage-plans");
		browserBack();
		mobileUtils.mobileLocateElement(footerMedicareSupplementInsurancePlansLink);
		mobileactiontab(footerMedicareSupplementInsurancePlansLink);
		validateLinks("/health-plans/shop/medicare-supplement-plans.html||health-plans.html?product=");
		browserBack();
		mobileUtils.mobileLocateElementClick(footerMedicarePrescriptionDrugPlansLink);
		validateLinks("/health-plans/shop/prescription-drug-plans");
		browserBack();
		mobileUtils.mobileLocateElementClick(footerMedicareEducationLink);
		validateLinks("/medicare-education.html");
		browserBack();
		mobileUtils.mobileLocateElementClick(footerHomeLink);
		browserBack();
		driver.navigate().refresh();
		pageloadcomplete();
		mobileUtils.mobileLocateElementClick(footerAboutUsLink);
		validateLinks("/about-us.html");
		browserBack();
		mobileUtils.mobileLocateElementClick(footerContactUsLink);
		validateLinks("/contact-us.html");
		browserBack();
		mobileUtils.mobileLocateElementClick(footerSiteMapLink);
		validateLinks("/sitemap.html");
		browserBack();
		mobileUtils.mobileLocateElementClick(footerPrivacyPolicyLink);
		validateLinks("/privacy_policy.html");
		browserBack();
		mobileUtils.mobileLocateElementClick(footerTermsofUseLink);
		validateLinks("/terms-of-use.html");
		browserBack();
		mobileUtils.mobileLocateElementClick(footerDisclaimersLink);
		validateLinks("/disclaimer.html");
		browserBack();
		mobileUtils.mobileLocateElementClick(footerAgentsBrokersLink);
		validateLinks("/health-insurance-brokers.html");
		browserBack();
		if (curURL.contains("uhcmedicare")) {
			mobileUtils.mobileLocateElementClick(footerAccessibilityLink);
			validateLinks("/legal/accessibility");
			browserBack();
		} else {
			curWindow = driver.getWindowHandle();
			// Open in another Window
			if (driver.getClass().toString().toUpperCase().contains("ANDROID")) {
				mobileUtils.mobileLocateElementClick(footerAccessibilityLink);
				validateLinksanotherWindowmobile("/legal/accessibility", curWindow);
			} else {
				navigatesubLink(footerAccessibilityLink.getAttribute("href"));
				browserBack();
			}
		}
	}

	public void validateLinks(String expURL) {
		pageloadcomplete();
		threadsleep(3000);
		String curURL = driver.getCurrentUrl();
		if (expURL.contains("||") && curURL.contains(expURL.split("\\|\\|")[0])
				|| expURL.contains("||") && curURL.contains(expURL.split("\\|\\|")[1])) {
			System.out.println("Link validation True");
		} else if (curURL.contains(expURL)) {
			System.out.println("Link validation True");
		} else {
			System.out.println("Link validation False");
			System.out.println("Expected URL " + expURL);
			System.out.println("Actual URL " + curURL);
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
		mobileswipe("90%", true);
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

	public void validateLinksanotherWindowmobile(String expURL, String primaryWindow) {
		threadsleep(2000);
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		if (windows.size() >= 2) {
			if (driver.getClass().toString().toUpperCase().contains("ANDROID")) {
				for (String window : windows) {
					if (!window.equals(primaryWindow)) {
						driver.switchTo().window(window);
						System.out.println(driver.getCurrentUrl());
						if (mobileUtils.fixLeavingProceedMobile()) {
							mobileUtils.fixPrivateConnectionMobile();
							validateLinks(expURL);
							driver.close();
						} else
							driver.close();
					}
				}
				driver.switchTo().window(primaryWindow);
			} else {
				validateLinks(expURL);
				driver.close();
			}
			System.out.println(driver.getCurrentUrl());
			threadsleep(1000);
		} else {
			System.out.println("Link validation fails in popup window" + expURL);
			driver.switchTo().window(primaryWindow);
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