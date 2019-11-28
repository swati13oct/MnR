/**
 * 
 */
package pages.acquisition.planSelectorEngine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.AcquisitionHomePage;

public class PlanSelectorHeaderAndFooter extends UhcDriver {

	public PlanSelectorHeaderAndFooter(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, AcquisitionHomePage.proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
//		waitforElementVisibilityInTime(getStartedBtn, 30);

	}

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

//Header Elements

	@FindBy(xpath = "//header[contains(@class,'header')]")
	private WebElement headerSection;
	
	@FindBy(xpath = "//*[@id='aarpSVGLogo']/img")
	private WebElement AARPlogoInHeader;
	
	@FindBy(xpath = "//a[@id='aarplink']")
	private WebElement headerVisitAARPOrgLink;
	
	@FindBy(xpath = "//*[@class='signup']/span[1]")
	private WebElement headerAlreadyAPlanMember;
	
	@FindBy(xpath = "//*[@class='signup']/span[2]")
	private WebElement headerAlreadyAPlanMemberPipeSymbol;
	
	@FindBy(xpath = "//*[@class='signup']/a[1]")
	private WebElement headerSigninLink;
	
	@FindBy(xpath = "//*[@class='signup']/a[2]")
	private WebElement headerRegisterLink;
	
	@FindBy(xpath = "//a[@id='dupIconFlyOut']//img[@dtmid='acq_visitor_profile']")
	private WebElement headerHeartImage;
	
	@FindBy(xpath = "//a[@id='dupIconFlyOut']/span")
	private WebElement headerHeartNumberofPlan;
	
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
	
	@FindBy(css = "//a[@class='back-to-top']")
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
		validate(headerSection, 30);
		validate(AARPlogoInHeader, 30);
		validate(headerVisitAARPOrgLink, 30);
		Assert.assertTrue(headerVisitAARPOrgLink.getText().contains("Visit AARP.org"));
		validate(headerAlreadyAPlanMember, 30);
		Assert.assertTrue(headerAlreadyAPlanMember.getText().contains("Already a Plan Member?"));
		validate(headerAlreadyAPlanMemberPipeSymbol, 30);
		Assert.assertTrue(headerAlreadyAPlanMemberPipeSymbol.getText().contains(" | "));
		validate(headerSigninLink, 30);
		Assert.assertTrue(headerSigninLink.getText().contains("Sign in"));
		validate(headerRegisterLink, 30);
		Assert.assertTrue(headerRegisterLink.getText().contains("Register"));
		validate(headerHeartNumberofPlan, 30);
	}
	
//	Footer Element Verification Method
	
	public void footerElements() {
		System.out.println("Validating Footer Elements: ");
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
