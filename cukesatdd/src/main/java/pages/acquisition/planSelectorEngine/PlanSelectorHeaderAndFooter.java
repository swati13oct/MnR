/**
 * 
 */
package pages.acquisition.planSelectorEngine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.AcquisitionHomePage;

public class PlanSelectorHeaderAndFooter extends UhcDriver {
	
	Actions actions = new Actions(driver);

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
	
	@FindBy(xpath = "//h1[contains(@class,'text-display')]")
	private WebElement landingpageHeader;

	@FindBy(xpath = "//header[contains(@class,'header')]")
	private WebElement headerSection;
	
	@FindBy(xpath = "//*[@id='aarpSVGLogo']/img")
	private WebElement AARPlogoInHeader;
	
	@FindBy(xpath = "//*[@id='ums-logo']")
	private WebElement UHClogoInHeader;
	
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
	
	@FindBy(css = "#collapsible-0>#nav>.uhc-container")
	private WebElement headerNavigationBar;
	
	@FindBy(css = "#ghn_lnk_1 > span")
	private WebElement headerNavigationBarHomeTab;
	
	@FindBy(css = "#ghn_lnk_2 > span")
	private WebElement headerNavigationBarShopForaPlanTab;
	
	@FindBy(css = "#ghn_lnk_3 > span")
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
		Assert.assertTrue(headerRegisterLink.getText().contains("Register"));
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
		Assert.assertTrue(headerMedicaresupplementplanLink.getText().contains("Medicare Supplement Plans"));
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

//MouseOver on Shop of a Plan and Validating Inside Shop of a Plan
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
		validate(headerFAQLink, 30);
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
		validate(footerMedicareSupplementInsurancePlansLink, 30);
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
	
//Navigating Plan RecommendationEngine via Get Plan Recommendation	
	public void navigationToPlanRecommendationEngine() {
		waitforElementVisibilityInTime(headerNavigationBarShopForaPlanTab, 45);
		actions.moveToElement(headerNavigationBarShopForaPlanTab).perform();
		headerGetaPlanRecommendationLink.click();
		validate(landingpageHeader, 30);
		Assert.assertTrue(landingpageHeader.getText().contains("Get help finding an insurance plan"));
	}
	
//Navigating Plan RecommendationEngine via Shop for a plan -->Shop-->Tools-->Get Help Choosing	
	public void navigationToPlanRecommendationEngineViaShopTools() {
		waitforElementVisibilityInTime(headerNavigationBarShopForaPlanTab, 45);
		actions.moveToElement(headerNavigationBarShopForaPlanTab).perform();
		headerShopLink.click();
		validate(HeaderShopToolsGetHelpChoosingLink, 30);
		HeaderShopToolsGetHelpChoosingLink.click();
		validate(landingpageHeader, 30);
		Assert.assertTrue(landingpageHeader.getText().contains("Get help finding an insurance plan"));
	}
	
//ZipCode Function inside Shop for a Plan
	public void zipcodeFunctionInShopforaplan(String zipcode) throws InterruptedException {
		waitforElementVisibilityInTime(headerNavigationBarShopForaPlanTab, 45);
		actions.moveToElement(headerNavigationBarShopForaPlanTab).perform();
		headerShopForaPlanZipcodeBox.click();
		headerShopForaPlanZipcodeBox.sendKeys(zipcode);
		headerShopForaPlanZipcodeButton.click();
		String actualpageurl = driver.getCurrentUrl();
		System.out.println("PlanSummary Page is :"+actualpageurl);
		String ExpectedPage = "plan-summary";
		Assert.assertTrue(actualpageurl.contains(ExpectedPage));
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().back();
	}
	
//Email Function inside Shop for a Plan	
	public void emailFunctionInShopforaplan(String email) {
		waitforElementVisibilityInTime(headerNavigationBarShopForaPlanTab, 45);
		actions.moveToElement(headerNavigationBarShopForaPlanTab).perform();
		headerShopForaPlanEmailBox.click();
		headerShopForaPlanEmailBox.sendKeys(email);
		headerShopForaPlanEmailButton.click();
		validate(headerShopForaPlanThankYou, 30);
	}
	
//	Enter Search Key Function in Navigation bar
	public void enterSearchFunction(String SearchKey) {
		waitforElementVisibilityInTime(headerNavigationBarEnterSearchTab, 45);
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
		}else {
			Assert.assertFalse(false, "Search function not working as expected");
		}
		
	}
	
//	Back to Top Function in Footer
	public void backtoTopFunction() {
		waitforElementVisibilityInTime(footerBackToTopLink, 45);
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

	public void browserBack() {

		driver.navigate().back();
	}
}
