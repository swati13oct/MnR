/**
 * 
 */
package pages.mobile.acquisition.planselectorengine;

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
	
	@FindBy(css = "#nav>a.nav-close")
	private WebElement headernavigationCloseicon;

	
//Footer Elements
	
	@FindBy(css = "footer.footer")
	private WebElement footerSection;
	
	@FindBy(css = "ul.visitaarp.linksCond > li > a")
	private WebElement footerVisitAARPOrgLink;
	
	@FindBy(css = "#gfn_lnk_row2_1 > span")
	private WebElement footerMedicareAdvantagePlansLink;
		
	@FindBy(css = ".linksCond:nth-of-type(2)>li:nth-of-type(2)")
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
	}
	
//	Footer Element Verification Method
	
	public void footerElementsMobile() {
		System.out.println("Validating Mobile Footer Elements: ");
		mobileswipe("95%");
		mobileswipe("95%");
		mobileswipe("95%");
		mobileswipe("95%");
		validate(footerSection, 30);
		validate(footerVisitAARPOrgLink, 30);
		Assert.assertTrue(footerVisitAARPOrgLink.getText().contains("Visit AARP.org"));
		validate(footerMedicareAdvantagePlansLink, 30);
		Assert.assertTrue(footerMedicareAdvantagePlansLink.getText().contains("Medicare Advantage Plans"));	
		validate(footerMedicareSupplementInsurancePlansLink, 30);
		Assert.assertTrue(footerMedicareSupplementInsurancePlansLink.getText().contains("Medicare Supplement Insurance Plans"));
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
