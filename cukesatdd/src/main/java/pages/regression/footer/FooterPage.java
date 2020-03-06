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

	public FooterPage (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate(){
		// TODO Auto-generated method stub
	}

	/* tbd 
	public void feebackpopupClose() throws InterruptedException
	{ //waitForloader(driver,overlay, 20);
		Thread.sleep(20000);
		if (validate(iPerceptionframe)) {

			switchToNewIframe(iPerceptionframe);
			iPerceptionclosebtn.click();
			driver.switchTo().defaultContent();
			//iPerceptionAutoPopUp.click();
		} else {
			System.out.println("iPerception Pop Up not displayed");
		}
	}
	
	    public void feebackpopupClose_shortwait() throws InterruptedException {
		//waitForloader(driver,overlay, 20);
		Thread.sleep(6000);
		if (iPerceptionframe.isDisplayed()) {

			switchToNewIframe(iPerceptionframe);
			iPerceptionclosebtn.click();
			driver.switchTo().defaultContent();
			//iPerceptionAutoPopUp.click();
		} else {
			System.out.println("iPerception Pop Up not displayed");
		}
	} */

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
		footerValidate(claimsLink);
		if(claimsLink.isDisplayed()){
			System.out.println("Claims link is displayed");
			claimsLink.click();
			System.out.println("Claims link is clicked");
		}
		return null;
	}	

	public FooterPage NavigateToEOBPage(){
		footerValidate(EOBLink);
		if(EOBLink.isDisplayed()){
			System.out.println("EOB link is displayed");
			EOBLink.click();
			System.out.println("EOB link is clicked");
		}
		return null;
	}

	public FooterPage NavigateToContactUsPage(){
		footerValidate(HelpandContactUs);
		if(HelpandContactUs.isDisplayed()){
			System.out.println("contactUSLink link is displayed");
			HelpandContactUs.click();
			System.out.println("contactUS link is clicked");
		}
		return null;
	}

	public FooterPage NavigateToBenefitsPage(){
		footerValidate(benefits);
		if(benefits.isDisplayed()){
			System.out.println("Benefits link is displayed");
			benefits.click();
			System.out.println("Benefits link is clicked");
		}
		return null;
	}

	public FooterPage NavigateToPharmacyLocator(){
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
		footerValidate(homeBtn);
		if(homeBtn.isDisplayed()){
			System.out.println("Home button is displayed");
			homeBtn.click();
			System.out.println("Home button is clicked");
			waitforElement(LookUpDrug);
			if(LookUpDrug.isDisplayed()){
				System.out.println("DCE link is displayed");
				LookUpDrug.click();
				System.out.println("DCE link is displayed");
			}
		}
		return null;
	}

	public FooterPage NavigateToProfileandPref(){
		footerValidate(accountprofile);
		if(accountprofile.isDisplayed()){
			System.out.println("accountprofile button is displayed");
			accountprofile.click();

			if(accountSettingOption.isDisplayed()) {
				System.out.println("Profile and Preferences link is displayed");
				accountSettingOption.click();
				System.out.println("Profile and Preferences link is clicked");
			} 
			
		}
		return null;
	}
	
	public FooterPage NavigateToProfileandPref_ship(){
		footerValidate(accountprofile);
		if(accountprofile.isDisplayed()){
			System.out.println("accountprofile button is displayed");
			accountprofile.click();
			if (accountSettingOptionShip.isDisplayed()) {
				System.out.println("Profile and Preferance link is displayed");
				accountSettingOptionShip.click();
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
			checkModelPopup(driver,5);
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
			checkModelPopup(driver,5);
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
		checkModelPopup(driver,5);
		CommonUtility.waitForPageLoad(driver, orderPlanMaterialsHeader, CommonConstants.TIMEOUT_90);
		if (driver.getCurrentUrl().contains("order-materials/overview.html")){
			System.out.println("Order Plan Materials Page is Loaded");
		}
		else{
			Assert.fail(">>>>>>>>>Order Plan Materials Page not loaded<<<<<<<<<<<<,");
		}
	}
}


