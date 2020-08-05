package pages.regression.footer;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class FooterPage extends UhcDriver {

	//======================Member Support ==========================//

	@FindBy(xpath= "(.//*[@class='col-md-12'])[13]")
	private WebElement MemberSupportFrame;

	@FindBy(id = "contact-help")
	private WebElement HelpandContactUs;
	
	@FindBy(xpath = "//*[@id='share-feedback']")
	private WebElement shareFeedback;

	@FindBy(linkText= "Account Settings")
	private WebElement AccountSettings;

	@FindBy(xpath= "//*[@id='notices']")
	private WebElement NoticesAndDisclosures;

	@FindBy(linkText= "Saved")
	private WebElement Saved;

	@FindBy(id= "accessibility")
	private WebElement AccessibilityStatement;
	
	@FindBy(id= "provider-data")
	private WebElement ProviderDataInformation;
	
	@FindBy(id= "legal-entities")
	private WebElement LegalEntities;


	@FindBy(xpath= "//*[@id='accessibility']")
	private WebElement Accessibility;

	@FindBy(linkText= "Logout")
	private WebElement Logout;

	@FindBy(xpath= "//*[@id='copyrightUHC']/p")
	private WebElement copyrightUnitedHealthcare;

	@FindBy(xpath= "//a[contains(text(),'Terms of Use')]")
	private WebElement TearmsOfUse;
	
	@FindBy(xpath= "//a[contains(text(),'Privacy Policy')]")
	private WebElement privacyPolicy;

	@FindBy(xpath = "//div[@class='row footerLinks']//*[@id='lastupdated']")
	private WebElement LastUpdate;
	
	@FindBy(xpath = "//a[contains(text(),'About United HealthCare')]")
	private WebElement aboutUnitedHealthCare;

	@FindBy(xpath= "//*[@id='language-assistance']")
	private WebElement LanguageAssistance;
	
	@FindBy(id= "language-assistance-spanish")
	private WebElement LanguageAssistanceSpanish;
	
	@FindBy(id= "language-assistance-chinese")
	private WebElement LanguageAssistanceChinese;
	
	@FindBy(id= "claims_1")
	private  WebElement claimsLink;

	@FindBy(id= "eobC1")
	private WebElement EOBLink;

	@FindBy(id= "contactUS_1")
	private WebElement contactUSLink;

	@FindBy(xpath= "//*[contains(text(),'Locate a Pharmacy')]")
	private WebElement LocateAPharmacy;

	@FindBy(xpath ="//*[contains(text(),'Look up Drugs')]")
	private WebElement LookUpDrug;

	@FindBy(id="home_2")
	private WebElement homeBtn;

	@FindBy(id="coveragebenefits_2")
	private WebElement benefits;

	@FindBy(id = "dropdown-toggle--1")
	private WebElement accountprofileFromDashboard;

	@FindBy(xpath = ".//*[@id='dropdown-options--1']/a[2]")
	private WebElement accountSettingOptionFromDashboard;
		
	@FindBy(id = "accountprofile")
	private WebElement accountprofile;

	@FindBy(id = "accsettings_3")
	private WebElement accountSettingOption;
	
	//@FindBy(linkText = "Account Settings") 
	@FindBy(xpath="//li[@class='accountSettings']//a[contains(text(),'Account Settings') or contains(text(),'ACCOUNT SETTINGS')]")
	private WebElement accountSettingOptionShip;
	
	@FindBy(id = "closeButton")
	public WebElement iPerceptionclosebtn;

	@FindBy(id = "IPerceptionsEmbed")
	public WebElement iPerceptionframe;
	
	@FindBy(xpath="//h1//*[contains(text(),'Health & Wellness')]")
	private WebElement healthAndWellnessHeader;
	
	@FindBy(id="healthwellness_6")
	private WebElement healthAndWellness;
	
	@FindBy(id="pharmacies_5")
	private WebElement pharmaciesAndPrescriptions;
	
	@FindBy(xpath="//h1[contains(text(),'Pharmacies & Prescriptions' )]")
	private WebElement pharmaciesAndPrescriptionsHeader;

	@FindBy(xpath="//h1[contains(text(),'Order Plan Materials' )]")
	private WebElement orderPlanMaterialsHeader;
	
	@FindBy(id="ordermaterials")
	private WebElement orderPlanMaterials;
	
	@FindBy(xpath="//ul[@class='unauth-footer-list']")
	protected WebElement unauthFooter_section;

	@FindBy(xpath="//ul[@class='unauth-footer-list']//a[contains(text(),'ABOUT US')]")
	protected WebElement unauthFooter_aboutUs;
	//href="/content/medicare/about/about-us.html"
	
	@FindBy(xpath="//ul[@class='unauth-footer-list']//a[contains(text(),'CONTACT US')]")
	protected WebElement unauthFooter_contactUs;
	//href="/content/medicare/about/contact-us/overview.html"

	@FindBy(xpath="//ul[@class='unauth-footer-list']//a[contains(text(),'PRIVACY POLICY')]")
	protected WebElement unauthFooter_privacyPolicy;
	//href="/content/medicare/about/privacy-policy.html"
	
	@FindBy(xpath="//ul[@class='unauth-footer-list']//a[contains(text(),'TERMS OF USE')]")
	protected WebElement unauthFooter_termsOfUse;
	//href="/content/medicare/about/terms-of-use.html"
	
	@FindBy(xpath="//ul[@class='unauth-footer-list']//a[contains(text(),'DISCLOSURES')]")
	protected WebElement unauthFooter_disclosures;
	//href="/content/medicare/about/disclaimers.html"
	
	@FindBy(xpath="//ul[@class='unauth-footer-list']//a[contains(text(),'ACCESSIBILITY')]")
	protected WebElement unauthFooter_accessibility;
	//href="https://www.uhc.com/legal/accessibility"
	
	@FindBy(xpath="//ul[@class='unauth-footer-list']//a[contains(text(),'LANGUAGE')]")
	protected WebElement unauthFooter_languageAssitance;
	//href="https://www.uhc.com/legal/medicare-plans"

	@FindBy(xpath="//ul[@class='unauth-footer-list']//a[contains(text(),'ASISTENCIA')]")
	protected WebElement unauthFooter_assistenciaDeIdiomas;
	//href="https://www.uhc.com/legal/medicare-plans"
	
	@FindBy(xpath="//ul[@class='unauth-footer-list']//a[contains(@href,'medicare-plans') and not(contains(text(),'LANGUAGE ASSISTANCE')) and not(contains(text(),'ASISTENCIA'))]")
	protected WebElement unauthFooter_assistChinese;
	//href="https://www.uhc.com/legal/medicare-plans"
	
	@FindBy(xpath="//ul[@class='unauth-footer-list']//a[contains(text(),'MEDICARE COMPLAINT FORM')]")
	protected WebElement unauthFooter_medicareComplaintForm;
	//href="https://www.medicare.gov/MedicareComplaintForm/home.aspx"
	
	@FindBy(xpath="//ul[@class='unauth-footer-list']//a[contains(text(),'DISASTER AND EMERGENCY SUPPORT')]")
	protected WebElement unauthFooter_disasterAndEmergencySupport;
	//href="/content/medicare/about/disaster-declaration.html" 
	
	@FindBy(xpath="//div[@data-ng-controller='dashboardGlobalController']//*[contains(text(),'Last update')]")
	protected WebElement unauthFooter_lastUpdate;

	@FindBy(xpath="//div[@data-ng-controller='dashboardGlobalController']//*[contains(text(),'All rights reserved')]")
	protected WebElement unauthFooter_allRightReserved;

	//note: need help section
	@FindBy(xpath="//h2[contains(@class,'atdd-need-help')]")
	protected WebElement needHelp_SectionHeader;

	//note: need help - technical section
	@FindBy(xpath="//div[contains(@class,'technical section')]")
	protected WebElement needHelp_TechicalSupportSection;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[1]//img")
	protected WebElement needHelp_TechicalSupport_img;

	@FindBy(xpath="//div[contains(@class,'technical section')]/div/div/p[1]")
	protected WebElement needHelp_TechicalSupport_phone;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[2]")
	protected WebElement needHelp_TechicalSupport_tty;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[3]")
	protected WebElement needHelp_TechicalSupport_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[4]")
	protected WebElement needHelp_TechicalSupport_wkEndHrs;

	//note: need help - general section
	@FindBy(xpath="//div[contains(@class,'general section')]")
	protected WebElement needHelp_GeneralQuestionsSection;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[1]//img")
	protected WebElement needHelp_GeneralQuestions_img;

	@FindBy(xpath="//div[contains(@class,'general section')]/div/div/p[1]")
	protected WebElement needHelp_GeneralQuestions_phone;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[2]")
	protected WebElement needHelp_GeneralQuestions_tty;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[3]")
	protected WebElement needHelp_GeneralQuestions_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[4]")
	protected WebElement needHelp_GeneralQuestions_wkEndHrs;

	//note: need help - claims section
	@FindBy(xpath="//div[contains(@class,'claims section')]")
	protected WebElement needHelp_ClaimsSupportSection;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[1]//img")
	protected WebElement needHelp_ClaimsSupport_img;

	@FindBy(xpath="//div[contains(@class,'claims section')]/div/div/div/p[1]")
	protected WebElement needHelp_ClaimsSupport_phone;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[2]")
	protected WebElement needHelp_ClaimsSupport_tty;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[3]")
	protected WebElement needHelp_ClaimsSupport_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[4]")
	protected WebElement needHelp_ClaimsSupport_wkEndHrs;

	//note: need help - plan support
	@FindBy(xpath="//div[contains(@class,'plan section')]")
	protected WebElement needHelp_PlanSupportSection;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[1]//img")
	protected WebElement needHelp_PlanSupport_img;

	@FindBy(xpath="//div[contains(@class,'plan section')]/div/div/p[1]")
	protected WebElement needHelp_PlanSupport_phone;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[2]")
	protected WebElement needHelp_PlanSupport_tty;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[3]")
	protected WebElement needHelp_PlanSupport_wkDayHrs;

	//note: need help - chat with us
	@FindBy(xpath="//div[contains(@class,'chatwithus')]")
	protected WebElement needHelp_ChatSection;

	@FindBy(xpath="//div[contains(@class,'chatwithus')]//img")
	protected WebElement needHelp_Chat_img;

	@FindBy(xpath="//div[contains(@class,'chatwithus')]//h3[contains(text(),'Chat with Us') or contains(text(),'Chat With Us')]")
	protected WebElement needHelp_Chat_header;

	@FindBy(xpath="//div[contains(@class,'chatwithus')]//div[contains(@class,'omniChat')]")
	protected WebElement needHelp_Chat_txt;
	
	//note: need help - more ways
	@FindBy(xpath="//p[contains(@id,'seeMoreWaysAtdd')][contains(text(),'See more ways to')]")
	protected WebElement needHelp_seeMoreWaysTo;

	@FindBy(xpath="//p[contains(@id,'seeMoreWaysAtdd')]//a[contains(text(),'contact us')]")
	protected WebElement needHelp_contactUsLink;

	//note: contact us - chat with us
	@FindBy(xpath="//div[contains(@class,'OMNIChatGroup') and not(contains(@class,'ng-hide'))]//*[contains(text(),'Chat With Us')]")
	protected WebElement contactUs_chatWithUs;

	//note: combo tabs
	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Med') and contains(.,'Drug')]") 
	protected WebElement comboTab_MAPD;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Supplement')]") 
	protected WebElement comboTab_SHIP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Prescription Drug Plan') and not(contains(.,'Med'))]") 
	protected WebElement comboTab_PDP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Senior Supplement Plan')]") 
	protected WebElement comboTab_SSUP;
	
	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,' Medicare Advantage Plan')]") 
	protected WebElement comboTab_MA;


	public FooterPage (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate(){
	}

	public Object validateFooterLinks() throws InterruptedException{
		CommonUtility.waitForPageLoad(driver, LastUpdate, 10);
		
		String section="LEFT COLUMN CONTENT";
		
		Assert.assertTrue("PROBLEM - unable to locate 'Provider Data Information' on '"+section+"' section", footerValidate(ProviderDataInformation));
		Assert.assertTrue("PROBLEM - unable to locate 'Notices And Disclosures' on '"+section+"' section", footerValidate(NoticesAndDisclosures));
		Assert.assertTrue("PROBLEM - unable to locate 'legal Entities' on '"+section+"' section", footerValidate(LegalEntities));

	    section="MIDDLE COLUMN CONTENT";
		
	    Assert.assertTrue("PROBLEM - unable to locate 'Help and Contact Us' on '"+section+"' section", footerValidate(HelpandContactUs));
	    Assert.assertTrue("PROBLEM - unable to locate 'Share Feedback' on '"+section+"' section", footerValidate(shareFeedback));
	    
	    section="RIGHT COLUMN CONTENT";
	
		Assert.assertTrue("PROBLEM - unable to locate 'Accessibility' on '"+section+"' section", footerValidate(Accessibility));
		Assert.assertTrue("PROBLEM - unable to locate 'LanguageAssistance' on '"+section+"' section", footerValidate(LanguageAssistance));
		Assert.assertTrue("PROBLEM - unable to locate 'Asistencia' on '"+section+"' section", footerValidate(LanguageAssistanceSpanish));
		Assert.assertTrue("PROBLEM - unable to locate 'LanguageAssistanceChinese' on '"+section+"' section", footerValidate(LanguageAssistanceChinese));

	     section="Bottom links";
		
		Assert.assertTrue("PROBLEM - unable to locate 'Last Update' on '"+section+"' section", footerValidate(LastUpdate));
		Assert.assertTrue("PROBLEM - unable to locate 'Terms Of Use' on '"+section+"' section", footerValidate(TearmsOfUse));
		Assert.assertTrue("PROBLEM - unable to locate 'Privacy Policy' on '"+section+"' section", footerValidate(privacyPolicy));
		Assert.assertTrue("PROBLEM - unable to locate 'CopyRight United Healthcare' on '"+section+"' section", footerValidate(copyrightUnitedHealthcare));
		Assert.assertTrue("PROBLEM - unable to locate 'About United Healthcare' on '"+section+"' section", footerValidate(aboutUnitedHealthCare));
		return null;
		}
	
	public FooterPage NavigateToClaimsPage(){
		footerCheckModelPopup(driver);
		footerValidate(claimsLink);
		if(claimsLink.isDisplayed()){
			System.out.println("Claims link is displayed");
			claimsLink.click();
			footerCheckModelPopup(driver);
			System.out.println("Claims link is clicked");
		}
		return null;
	}	

	public FooterPage NavigateToEOBPage(){
		footerCheckModelPopup(driver);
		footerValidate(EOBLink);
		if(EOBLink.isDisplayed()){
			System.out.println("EOB link is displayed");
			EOBLink.click();
			footerCheckModelPopup(driver);
			System.out.println("EOB link is clicked");
		}
		return null;
	}

	public FooterPage NavigateToContactUsPage(){
		footerCheckModelPopup(driver);
		footerValidate(HelpandContactUs);
		if(HelpandContactUs.isDisplayed()){
			System.out.println("contactUSLink link is displayed");
			HelpandContactUs.click();
			footerCheckModelPopup(driver);
			System.out.println("contactUS link is clicked");
		}
		return null;
	}

	public FooterPage NavigateToBenefitsPage(){
		footerCheckModelPopup(driver);
		footerValidate(benefits);
		if(benefits.isDisplayed()){
			System.out.println("Benefits link is displayed");
			benefits.click();
			footerCheckModelPopup(driver);
			System.out.println("Benefits link is clicked");
		}
		return null;
	}

	public FooterPage NavigateToPharmacyLocator(){
		footerCheckModelPopup(driver);
		footerValidate(homeBtn);
		if(homeBtn.isDisplayed()){
			System.out.println("Home button is displayed");
			homeBtn.click();
			System.out.println("Home button is clicked");
			waitforElement(LocateAPharmacy);
			if(LocateAPharmacy.isDisplayed()){
				System.out.println("Pharmacy link is displayed");
				LocateAPharmacy.click();
				System.out.println("pharmacy link is displayed");
			}
		}
		return null;
	}

	public FooterPage NavigateToDCE(){
		footerCheckModelPopup(driver);
		footerValidate(homeBtn);
		if(homeBtn.isDisplayed()){
			System.out.println("Home button is displayed");
			homeBtn.click();
			footerCheckModelPopup(driver);
			System.out.println("Home button is clicked");
			waitforElement(LookUpDrug);
			if(LookUpDrug.isDisplayed()){
				System.out.println("DCE link is displayed");
				LookUpDrug.click();
				footerCheckModelPopup(driver);
				System.out.println("DCE link is displayed");
			}
		}
		return null;
	}

	public FooterPage NavigateToProfileandPref(){
		footerCheckModelPopup(driver);
		scrollElementToCenterScreen(accountprofile);
		footerValidate(accountprofile);
		if(accountprofile.isDisplayed()){
			System.out.println("accountprofile button is displayed");
			accountprofile.click();
			footerCheckModelPopup(driver);
			if(accountSettingOption.isDisplayed()) {
				System.out.println("Profile and Preferences link is displayed");
				accountSettingOption.click();
				footerCheckModelPopup(driver);
				System.out.println("Profile and Preferences link is clicked");
			} 
			
		}
		return null;
	}
	
	public FooterPage NavigateToProfileandPref_ship(){
		footerCheckModelPopup(driver);
		footerValidate(accountprofile);
		if(accountprofile.isDisplayed()){
			System.out.println("accountprofile button is displayed");
			JavascriptExecutor ex=(JavascriptExecutor)driver;
			ex.executeScript("arguments[0].click()", accountprofile);
			footerCheckModelPopup(driver);
			if (accountSettingOptionShip.isDisplayed()) {
				System.out.println("Profile and Preferance link is displayed");
				accountSettingOptionShip.click();
				footerCheckModelPopup(driver);
				System.out.println("Profile and Preferance link is clicked");
			}
		}
		return null;
	}

	public FooterPage validatePageFooter(){
		return new FooterPage(driver);
	}

	public boolean footerValidate(WebElement element) {
		long timeoutInSec=0;
		return footerValidate(element, timeoutInSec);
	} 

	/**
	 * to validate whether element exists with input timeout value control
	 * note: use this instead of the one from UhcDriver which takes up to 30 sec to timeout
	 * @param element
	 * @param timeoutInSec
	 * @return
	 */
	public boolean footerValidate(WebElement element, long timeoutInSec) {
		//note: if ever need to control the wait time out, use the one in UhcDriver validate(element, timeoutInSec)
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		try {
			if (element.isDisplayed()) {
				System.out.println("Element '"+element.toString()+"' found!!!!");
				return true;
			} else {
				System.out.println("Element '"+element.toString()+"' not found/not visible");
			}
		} catch (Exception e) {
			System.out.println("Element '"+element.toString()+"' not found/not visible. Exception");
		}
		//note: default in UhcDriver is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		return false;
	} 


	public void sleepBySec(int sec) {
		System.out.println("Sleeping for '"+sec+"' sec");
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void footerCheckModelPopup(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); 
		checkModelPopup(driver,5);
		//note: UhcDriver default is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 

	}
	
	public void NavigateToHealthAndWelnessPage() {
		    footerValidate(healthAndWellness);
			healthAndWellness.click();
			CommonUtility.checkPageIsReady(driver);
			footerCheckModelPopup(driver);
			CommonUtility.waitForPageLoad(driver, healthAndWellnessHeader, CommonConstants.TIMEOUT_90);
			if (driver.getTitle().contains("Health And Wellness")) {
				System.out.println("Health and wellness Page is Loaded");
			}
			else{
				Assert.fail(">>>>>>>>>Health and Wellness page not loaded<<<<<<<<<<<<,");
			}
	}
	
	public void NavigateToPharmaciesAndPrescriptionsPage() {
		 footerValidate(pharmaciesAndPrescriptions);
		    pharmaciesAndPrescriptions.click();
			CommonUtility.checkPageIsReady(driver);
			footerCheckModelPopup(driver);
			CommonUtility.waitForPageLoad(driver, pharmaciesAndPrescriptionsHeader, CommonConstants.TIMEOUT_90);
			if (driver.getCurrentUrl().contains("pharmacy/overview.html")){
				System.out.println("Pharmacies and Prescriptions Page is Loaded");
			}
			else{
				Assert.fail(">>>>>>>>>Pharmacies and Prescriptions Page not loaded<<<<<<<<<<<<,");
			}
	}

	public void NavigateToOrderPlanMaterialsPage() {
		footerValidate(benefits);
		sleepBySec(3);
		footerValidate(orderPlanMaterials);
		orderPlanMaterials.click();
		CommonUtility.checkPageIsReady(driver);
		footerCheckModelPopup(driver);
		CommonUtility.waitForPageLoad(driver, orderPlanMaterialsHeader, CommonConstants.TIMEOUT_90);
		if (driver.getCurrentUrl().contains("order-materials/overview.html")){
			System.out.println("Order Plan Materials Page is Loaded");
		}
		else{
			Assert.fail(">>>>>>>>>Order Plan Materials Page not loaded<<<<<<<<<<<<,");
		}
	}
	
	public void validateSignInPgFooter() {
		CommonUtility.waitForPageLoad(driver, unauthFooter_lastUpdate, 10);
		Assert.assertTrue("PROBLEM - unable to locate footer section on sign-in page", footerValidate(unauthFooter_section));
		
		String testLinkName="ABOUT US";
		WebElement testElement=unauthFooter_aboutUs;
		Assert.assertTrue("PROBLEM - unable to locate footer element '"+testLinkName+"' on sign-in page", footerValidate(testElement));
		String expLink="/content/medicare/about/about-us.html";
		String actLink=testElement.getAttribute("href");
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href attribute should not be null", actLink!=null);
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href does not contain expected href. "
				+ "Expected to contain '"+expLink+"' | Actual ='"+actLink+"'", actLink.contains(expLink));
		
		testLinkName="PRIVACY POLICY";
		testElement=unauthFooter_privacyPolicy;
		expLink="/content/medicare/about/privacy-policy.html";
		actLink=testElement.getAttribute("href");
		Assert.assertTrue("PROBLEM - unable to locate footer element '"+testLinkName+"' on sign-in page", footerValidate(testElement));
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href attribute should not be null", actLink!=null);
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href does not contain expected href. "
				+ "Expected to contain '"+expLink+"' | Actual ='"+actLink+"'", actLink.contains(expLink));		
		
		testLinkName="TERMS OF USE";
		testElement=unauthFooter_termsOfUse;
		expLink="/content/medicare/about/terms-of-use.html";
		actLink=testElement.getAttribute("href");
		Assert.assertTrue("PROBLEM - unable to locate footer element '"+testLinkName+"' on sign-in page", footerValidate(testElement));
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href attribute should not be null", actLink!=null);
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href does not contain expected href. "
				+ "Expected to contain '"+expLink+"' | Actual ='"+actLink+"'", actLink.contains(expLink));

		testLinkName="DISCLOSURES";
		testElement=unauthFooter_disclosures;
		expLink="/content/medicare/about/disclaimers.html";
		actLink=testElement.getAttribute("href");
		Assert.assertTrue("PROBLEM - unable to locate footer element '"+testLinkName+"' on sign-in page", footerValidate(testElement));
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href attribute should not be null", actLink!=null);
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href does not contain expected href. "
				+ "Expected to contain '"+expLink+"' | Actual ='"+actLink+"'", actLink.contains(expLink));

		testLinkName="ACCESSIBILITY";
		testElement=unauthFooter_accessibility;
		expLink="/legal/accessibility";
		actLink=testElement.getAttribute("href");
		Assert.assertTrue("PROBLEM - unable to locate footer element '"+testLinkName+"' on sign-in page", footerValidate(testElement));
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href attribute should not be null", actLink!=null);
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href does not contain expected href. "
				+ "Expected to contain '"+expLink+"' | Actual ='"+actLink+"'", actLink.contains(expLink));
		
		
		testLinkName="LANGUAGE ASSISTANCE / NON-DISCRIMINATION";
		testElement=unauthFooter_languageAssitance;
		expLink="/legal/medicare-plans";
		actLink=testElement.getAttribute("href");
		Assert.assertTrue("PROBLEM - unable to locate footer element '"+testLinkName+"' on sign-in page", footerValidate(testElement));
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href attribute should not be null", actLink!=null);
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href does not contain expected href. "
				+ "Expected to contain '"+expLink+"' | Actual ='"+actLink+"'", actLink.contains(expLink));
	
		
		testLinkName="ASISTENCIA DE IDIOMAS / AVISO DE NO DISCRIMINACIÓN";
		testElement=unauthFooter_assistenciaDeIdiomas;
		expLink="/legal/medicare-plans";
		actLink=testElement.getAttribute("href");
		Assert.assertTrue("PROBLEM - unable to locate footer element '"+testLinkName+"' on sign-in page", footerValidate(testElement));
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href attribute should not be null", actLink!=null);
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href does not contain expected href. "
				+ "Expected to contain '"+expLink+"' | Actual ='"+actLink+"'", actLink.contains(expLink));

		testLinkName="Chinese LANGUAGE ASSISTANCE";
		testElement=unauthFooter_assistChinese;
		expLink="/legal/medicare-plans";
		actLink=testElement.getAttribute("href");
		Assert.assertTrue("PROBLEM - unable to locate footer element '"+testLinkName+"' on sign-in page", footerValidate(testElement));
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href attribute should not be null", actLink!=null);
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href does not contain expected href. "
				+ "Expected to contain '"+expLink+"' | Actual ='"+actLink+"'", actLink.contains(expLink));

		testLinkName="MEDICARE COMPLAINT FORM";
		testElement=unauthFooter_medicareComplaintForm;
		expLink="https://www.medicare.gov/MedicareComplaintForm/home.aspx";
		actLink=testElement.getAttribute("href");
		Assert.assertTrue("PROBLEM - unable to locate footer element '"+testLinkName+"' on sign-in page", footerValidate(testElement));
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href attribute should not be null", actLink!=null);
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href does not contain expected href. "
				+ "Expected to contain '"+expLink+"' | Actual ='"+actLink+"'", actLink.contains(expLink));

		testLinkName="DISASTER AND EMERGENCY SUPPORT";
		testElement=unauthFooter_disasterAndEmergencySupport;
		expLink="/content/medicare/about/disaster-declaration.html";
		actLink=testElement.getAttribute("href");
		Assert.assertTrue("PROBLEM - unable to locate footer element '"+testLinkName+"' on sign-in page", footerValidate(testElement));
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href attribute should not be null", actLink!=null);
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href does not contain expected href. "
				+ "Expected to contain '"+expLink+"' | Actual ='"+actLink+"'", actLink.contains(expLink));		
	
		Assert.assertTrue("PROBLEM - unable to locate footer element 'Last Update' on sign-in page", footerValidate(unauthFooter_lastUpdate));

		Assert.assertTrue("PROBLEM - unable to locate footer element 'All Right Reserved' on sign-in page", footerValidate(unauthFooter_allRightReserved));
	}
	
	public void moveMouseToElement(WebElement targetElement) {
		Actions action = new Actions(driver);
		action.moveToElement(targetElement).build().perform(); 
	}
	
	public void validateContactUsChatWithUs(String planType, String memberType) {
		if (planType.toUpperCase().contains("SHIP") || planType.toUpperCase().contains("MEDSUPP") || memberType.toUpperCase().startsWith("SHIP_FED_COMBO")) 
			Assert.assertTrue("PROBLEM - should not be able to locate the Chat With Us section on Contact Us page that is for SHIP user or with SHIP plan priority",
				!footerValidate(contactUs_chatWithUs));
		else 
			Assert.assertTrue("PROBLEM - unable to locate the Chat With Us section on Contact Us page that is for Federal user",
					footerValidate(contactUs_chatWithUs));
		}

	/**
	 * Validate Need Help section content
	 * note: Tab structure is Suppressed if the information provided on both the tabs is exactly similar. 
	 * note: So in this case we not show the P&P page in case of a standalone ship member 
	 * note: and will show the P&P page without any Plan Tabs in case of a combo member
	 * note: COMBO user with SHIP plan will have SHIP's need help content
	 * @param planType
	 * @param memberType
	 * @return
	 * @throws InterruptedException 
	 */
	public String validateNeedHelpSection(String planType, String memberType) 
			throws InterruptedException {
		if (planType.toUpperCase().contains("SHIP") || planType.toUpperCase().contains("MEDSUPP")) {
			System.out.println("Proceed to validate the Need Help section header");
			Assert.assertTrue("PROBLEM - unable to locate the Need Help section header element",
					footerValidate(needHelp_SectionHeader));

			String validateSection="Need Help - Technical Support";
			validateNeedHelpSectionContent(validateSection, needHelp_TechicalSupportSection, 
					needHelp_TechicalSupport_img, needHelp_TechicalSupport_phone, 
					needHelp_TechicalSupport_tty, needHelp_TechicalSupport_wkDayHrs,
					needHelp_TechicalSupport_wkEndHrs);

			validateSection="Need Help - General Questions";
			validateNeedHelpSectionContent(validateSection, needHelp_GeneralQuestionsSection, 
					needHelp_GeneralQuestions_img, needHelp_GeneralQuestions_phone, 
					needHelp_GeneralQuestions_tty, needHelp_GeneralQuestions_wkDayHrs,
					needHelp_GeneralQuestions_wkEndHrs);

			validateSection="Need Help - Claims Support";
			validateNeedHelpSectionContent(validateSection, needHelp_ClaimsSupportSection, 
					needHelp_ClaimsSupport_img, needHelp_ClaimsSupport_phone, 
					needHelp_ClaimsSupport_tty, needHelp_ClaimsSupport_wkDayHrs,
					needHelp_ClaimsSupport_wkEndHrs);

			System.out.println("Proceed to validate the Need Help - See More Ways section content");
			Assert.assertTrue("PROBLEM - unable to locate the 'See more ways to' text in Need Help section",
					footerValidate(needHelp_seeMoreWaysTo));
			Assert.assertTrue("PROBLEM - unable to locate the 'contact us' link in Need Help section",
					footerValidate(needHelp_contactUsLink));
			/* keep for now
			needHelp_contactUsLink.click();
			CommonUtility.checkPageIsReady(driver);
			//tbd handleComboTabIfComboUser(planType, memberType);
			String expContactUsTitle="Help & Contact Us";
			String expContactUsUrl="content/medicare/member/contact-us/overview.html#/contact-us-three";
			System.out.println("New window URL = "+driver.getCurrentUrl()+"| New window title = "+driver.getTitle());
			Assert.assertTrue("PROBLEM - not getting expected contact us URL. "
					+ "Expected to contains='"+expContactUsUrl+"' | Actual URL='"+driver.getCurrentUrl()+"'", 
					driver.getCurrentUrl().contains(expContactUsUrl));
			Assert.assertTrue("PROBLEM - not getting expected contact us Title. "
					+ "Expected to contains='"+expContactUsTitle+"' | Actual URL='"+driver.getTitle()+"'", 
					driver.getTitle().contains(expContactUsTitle));
			goBackToPriorPnPpgViaBack(planType, memberType);
			*/
		} else {
			System.out.println("Proceed to validate the Need Help section header");
			Assert.assertTrue("PROBLEM - unable to locate the Need Help section header element",
					footerValidate(needHelp_SectionHeader));

			String validateSection="Need Help - Technical Support";
			validateNeedHelpSectionContent(validateSection, needHelp_TechicalSupportSection, 
					needHelp_TechicalSupport_img, needHelp_TechicalSupport_phone, 
					needHelp_TechicalSupport_tty, needHelp_TechicalSupport_wkDayHrs,null);

			validateSection="Need Help - Plan Support";
			validateNeedHelpSectionContent(validateSection, needHelp_PlanSupportSection, 
					needHelp_PlanSupport_img, needHelp_PlanSupport_phone, needHelp_PlanSupport_tty, 
					needHelp_PlanSupport_wkDayHrs, null);
			
			//validateSection="Need Help - Chat With Us";
			//Assert.assertTrue("PROBLEM - unable to locate the "+validateSection+" section element - Chat Section", footerValidate(needHelp_ChatSection));
			//Assert.assertTrue("PROBLEM - unable to locate the "+validateSection+" section element - Chat img", footerValidate(needHelp_Chat_img));
			//Assert.assertTrue("PROBLEM - unable to locate the "+validateSection+" section element - Chat section header", footerValidate(needHelp_Chat_header));
			//Assert.assertTrue("PROBLEM - unable to locate the "+validateSection+" section element - Chat txt", footerValidate(needHelp_Chat_txt));
		}
		System.out.println("Main window = "+driver.getTitle());
		return driver.getCurrentUrl();
	}

	/**
	 * Helper method for validating Need Help section
	 * @param section
	 * @param SectionElement
	 * @param imgElement
	 * @param phoneElement
	 * @param ttyElement
	 * @param hrsOperationElement1
	 * @param hrsOperationElement2
	 */
	public void validateNeedHelpSectionContent(String section, WebElement SectionElement, WebElement imgElement, 
			WebElement phoneElement, WebElement ttyElement, WebElement hrsOperationElement1, WebElement hrsOperationElement2) {
		System.out.println("Proceed to validate the "+section+" section content");
		Assert.assertTrue("PROBLEM - unable to locate the "+section+" section element", footerValidate(SectionElement));
		Assert.assertTrue("PROBLEM - unable to locate the img elemnt in "+section+" section", footerValidate(imgElement));
		Assert.assertTrue("PROBLEM - unable to locate the phone elemnt in "+section+" section", footerValidate(phoneElement));
		Assert.assertTrue("PROBLEM - unable to locate the TTY elemnt in "+section+" section", footerValidate(ttyElement));
		Assert.assertTrue("PROBLEM - unable to locate the hours of operation for week elemnt in "+section+" section", footerValidate(hrsOperationElement1));
		if (hrsOperationElement2!=null) {
			Assert.assertTrue("PROBLEM - unable to locate the hours of operation for week elemnt in "+section+" section", footerValidate(hrsOperationElement2));
		}
	}

	
	/**
	 * Helper method to go back to prior page via browser back, 
	 * also handles the case if combo tab is involved
	 * note: Tab structure is Suppressed if the information provided on both the tabs is exactly similar. 
	 * note: So in this case we not show the P&P page in case of a standalone ship member 
	 * note: and will show the P&P page without any Plan Tabs in case of a combo member
	 * @param planType
	 * @param memberType
	 * @param originalUrl
	 * @throws InterruptedException 
	 */
	public void goBackToPriorPnPpgViaBack(String planType, String memberType) 
			throws InterruptedException {
		driver.navigate().back();
		CommonUtility.checkPageIsReady(driver);
		String expUrl="/member/pharmacy/overview.html";
		String actUrl=driver.getCurrentUrl();
		Assert.assertTrue("PROBLEM - unable to go back to PnP page. "
				+ "Expect URL contain '"+expUrl+"' | Actual URL='"+actUrl+"'", actUrl.contains(expUrl));
		//tbd handleComboTabIfComboUser(planType, memberType);
	}

	/**
	 * Navigate to specific plan for combo user, default will fail it if user doesn't have combo
	 * @param planType
	 */
	public void goToSpecificComboTabOnTargetPage(String planType) throws InterruptedException{
		CommonUtility.checkPageIsReady(driver);
		WebElement targetTab=null;
		if (planType.equalsIgnoreCase("MAPD")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for MAPD", 
					footerValidate(comboTab_MAPD));
			targetTab=comboTab_MAPD;
		} else if (planType.equalsIgnoreCase("SHIP") 
				|| planType.equalsIgnoreCase("MEDSUPP")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for SHIP", 
					footerValidate(comboTab_SHIP));
			targetTab=comboTab_SHIP;
		} else if (planType.equalsIgnoreCase("PDP")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for PDP", 
					footerValidate(comboTab_PDP));
			targetTab=comboTab_PDP;
		} else if (planType.equalsIgnoreCase("SSUP")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for SSUP", 
					footerValidate(comboTab_SSUP));
			targetTab=comboTab_SSUP;
		} 
		else if (planType.equalsIgnoreCase("MA")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for MA", 
					footerValidate(comboTab_MA));
			targetTab=comboTab_MA;
		}else {
			Assert.assertTrue("PROBLEM - need to enhance code to cover "
					+ "planType '"+planType+"' for combo testing", false);
		}
		targetTab.click();
		targetTab.click();
		CommonUtility.checkPageIsReady(driver);
		Thread.sleep(1000); //note: keep to give it a sec to stable	}
	}

	public void scrollElementToCenterScreen(WebElement element) {
		String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
		                                            + "var elementTop = arguments[0].getBoundingClientRect().top;"
		                                            + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
		((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
		System.out.println("TEST - move element to center view"); 
		/* JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element); */
	}

}


