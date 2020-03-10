package pages.regression.footer;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	@FindBy(linkText = "Account Settings") 
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



	public FooterPage (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate(){
	}

	public Object validateFooterLinks() throws InterruptedException{
		sleepBySec(5);
		
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
			accountprofile.click();
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
		Assert.assertTrue("PROBLEM - unable to locate footer section on sign-in page", footerValidate(unauthFooter_section));
		
		String testLinkName="ABOUT US";
		WebElement testElement=unauthFooter_aboutUs;
		Assert.assertTrue("PROBLEM - unable to locate footer element '"+testLinkName+"' on sign-in page", footerValidate(testElement));
		String expLink="/content/medicare/about/about-us.html";
		String actLink=testElement.getAttribute("href");
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href does not contain expected href. "
				+ "Expected to contain '"+expLink+"' | Actual ='"+actLink+"'", actLink.contains(expLink));
		
		testLinkName="PRIVACY POLICY";
		testElement=unauthFooter_privacyPolicy;
		expLink="/content/medicare/about/privacy-policy.html";
		actLink=testElement.getAttribute("href");
		Assert.assertTrue("PROBLEM - unable to locate footer element '"+testLinkName+"' on sign-in page", footerValidate(testElement));
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href does not contain expected href. "
				+ "Expected to contain '"+expLink+"' | Actual ='"+actLink+"'", actLink.contains(expLink));		
		
		testLinkName="TERMS OF USE";
		testElement=unauthFooter_termsOfUse;
		expLink="/content/medicare/about/terms-of-use.html";
		actLink=testElement.getAttribute("href");
		Assert.assertTrue("PROBLEM - unable to locate footer element '"+testLinkName+"' on sign-in page", footerValidate(testElement));
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href does not contain expected href. "
				+ "Expected to contain '"+expLink+"' | Actual ='"+actLink+"'", actLink.contains(expLink));

		testLinkName="DISCLOSURES";
		testElement=unauthFooter_disclosures;
		expLink="/content/medicare/about/disclaimers.html";
		actLink=testElement.getAttribute("href");
		Assert.assertTrue("PROBLEM - unable to locate footer element '"+testLinkName+"' on sign-in page", footerValidate(testElement));
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href does not contain expected href. "
				+ "Expected to contain '"+expLink+"' | Actual ='"+actLink+"'", actLink.contains(expLink));

		testLinkName="ACCESSIBILITY";
		testElement=unauthFooter_accessibility;
		expLink="/legal/accessibility";
		actLink=testElement.getAttribute("href");
		Assert.assertTrue("PROBLEM - unable to locate footer element '"+testLinkName+"' on sign-in page", footerValidate(testElement));
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href does not contain expected href. "
				+ "Expected to contain '"+expLink+"' | Actual ='"+actLink+"'", actLink.contains(expLink));
		
		
		testLinkName="LANGUAGE ASSISTANCE / NON-DISCRIMINATION";
		testElement=unauthFooter_languageAssitance;
		expLink="/legal/medicare-plans";
		actLink=testElement.getAttribute("href");
		Assert.assertTrue("PROBLEM - unable to locate footer element '"+testLinkName+"' on sign-in page", footerValidate(testElement));
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href does not contain expected href. "
				+ "Expected to contain '"+expLink+"' | Actual ='"+actLink+"'", actLink.contains(expLink));
	
		
		testLinkName="ASISTENCIA DE IDIOMAS / AVISO DE NO DISCRIMINACIÓN";
		testElement=unauthFooter_assistenciaDeIdiomas;
		expLink="/legal/medicare-plans";
		actLink=testElement.getAttribute("href");
		Assert.assertTrue("PROBLEM - unable to locate footer element '"+testLinkName+"' on sign-in page", footerValidate(testElement));
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href does not contain expected href. "
				+ "Expected to contain '"+expLink+"' | Actual ='"+actLink+"'", actLink.contains(expLink));

		testLinkName="Chinese LANGUAGE ASSISTANCE";
		testElement=unauthFooter_assistChinese;
		expLink="/legal/medicare-plans";
		actLink=testElement.getAttribute("href");
		Assert.assertTrue("PROBLEM - unable to locate footer element '"+testLinkName+"' on sign-in page", footerValidate(testElement));
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href does not contain expected href. "
				+ "Expected to contain '"+expLink+"' | Actual ='"+actLink+"'", actLink.contains(expLink));

		testLinkName="MEDICARE COMPLAINT FORM";
		testElement=unauthFooter_medicareComplaintForm;
		expLink="https://www.medicare.gov/MedicareComplaintForm/home.aspx";
		actLink=testElement.getAttribute("href");
		Assert.assertTrue("PROBLEM - unable to locate footer element '"+testLinkName+"' on sign-in page", footerValidate(testElement));
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href does not contain expected href. "
				+ "Expected to contain '"+expLink+"' | Actual ='"+actLink+"'", actLink.contains(expLink));

		testLinkName="DISASTER AND EMERGENCY SUPPORT";
		testElement=unauthFooter_disasterAndEmergencySupport;
		expLink="/content/medicare/about/disaster-declaration.html";
		actLink=testElement.getAttribute("href");
		Assert.assertTrue("PROBLEM - unable to locate footer element '"+testLinkName+"' on sign-in page", footerValidate(testElement));
		Assert.assertTrue("PROBLEM - ufooter element '"+testLinkName+"' href does not contain expected href. "
				+ "Expected to contain '"+expLink+"' | Actual ='"+actLink+"'", actLink.contains(expLink));		
	
		Assert.assertTrue("PROBLEM - unable to locate footer element 'Last Update' on sign-in page", footerValidate(unauthFooter_lastUpdate));

		Assert.assertTrue("PROBLEM - unable to locate footer element 'All Right Reserved' on sign-in page", footerValidate(unauthFooter_allRightReserved));
	}

	
}


