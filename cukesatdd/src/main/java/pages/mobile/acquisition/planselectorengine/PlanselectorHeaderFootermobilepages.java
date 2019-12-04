/**
 * 
 */
package pages.mobile.acquisition.planselectorengine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.itextpdf.text.log.SysoCounter;

import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.AcquisitionHomePage;

public class PlanselectorHeaderFootermobilepages extends UhcDriver {

	public PlanselectorHeaderFootermobilepages(WebDriver driver) {
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
	
	@FindBy(css = "#aarpSVGLogo>img")
	private WebElement AARPlogoInHeader;
	
	@FindBy(css = "a#dupIconFlyOut img[dtmid='acq_visitor_profile']")
	private WebElement headerHeartImage;
	
	@FindBy(css = "a#dupIconFlyOut>span")
	private WebElement headerHeartNumberofPlan;
	
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
	
	// Shop for s plan inner elements
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
		
	@FindBy(css = ".linksCond:nth-of-type(2)>li:nth-of-type(2)") //Geotargetting
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
	
	public void headerElementsMobile() {
		System.out.println("Validating Mobile Header Elements: ");
		validate(headerSectionmenu, 30);
		validate(AARPlogoInHeader, 30);
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
		validate(headerVisitAARPOrgLink, 30);
		Assert.assertTrue(headerVisitAARPOrgLink.getText().contains("Visit AARP.org"));
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
	
//	Footer Element Verification Method
	
	public void footerElementsMobile() {
		System.out.println("Validating Mobile Footer Elements: ");
		mobileswipe("95%",4);
		validate(footerSection, 30);
		validate(footerVisitAARPOrgLink, 30);
		Assert.assertTrue(footerVisitAARPOrgLink.getText().contains("Visit AARP.org"));
		validate(footerMedicareAdvantagePlansLink, 30);
		Assert.assertTrue(footerMedicareAdvantagePlansLink.getText().contains("Medicare Advantage Plans"));	
		try {
			if(footerMedicareSupplementInsurancePlansLink.isDisplayed())
				Assert.assertTrue(footerMedicareSupplementInsurancePlansLink.getText().contains("Medicare Supplement Insurance Plans"));
			}catch(Exception e){
				System.out.println("Medicare Supplement Insurance Plans link is not available on footer for selected geo location");
			}
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

	public void browserBack() {
		driver.navigate().back();
	}
}
