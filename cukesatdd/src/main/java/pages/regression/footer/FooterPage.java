package pages.regression.footer;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.data.PageData;
import atdd.framework.UhcDriver;

public class FooterPage extends UhcDriver {

	//======================Member Support ==========================//

	@FindBy(xpath= "(.//*[@class='col-md-12'])[13]")
	private WebElement MemberSupportFrame;

	@FindBy(linkText = "Help & Contact Us")
	private WebElement HelpandContactUs;

	@FindBy(linkText= "Account Settings")
	private WebElement AccountSettings;

	@FindBy(linkText= "Legal Notices & Disclosures")
	private WebElement LegalNoticesAndDisclosures;

	@FindBy(linkText= "Saved")
	private WebElement Saved;

	@FindBy(linkText= "Accessibility")
	private WebElement Accessibility;

	@FindBy(linkText= "Logout")
	private WebElement Logout;

	@FindBy(xpath= "//footer//div[contains(@class,'iparys_inherited')]/div/div/div[1]//div[@class='row footerLinks']")
	private WebElement UnitedHealthcare;

	@FindBy(xpath= "//*[@id='termsofuseID']")
	private WebElement TearmsOfUse;

	@FindBy(xpath = "//div[@class='row footerLinks']//*[@id='lastupdated']")
	private WebElement LastUpdate;

	@FindBy(xpath= "//footer//div[contains(@class,'iparys_inherited')]/div/div/div[2]//div[@class='row footerLinks']//p[1]")
	private WebElement LanguageAssistance;

	@FindBy(xpath= "//footer//div[contains(@class,'iparys_inherited')]/div/div/div[2]//div[@class='row footerLinks']//p[2]")
	private WebElement Asistencia;

	@FindBy(xpath ="//footer//div[contains(@class,'iparys_inherited')]/div/div/div[2]//div[@class='row footerLinks']//p[3]")
	private WebElement OtherLanguageLink;

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

	@FindBy(id = "ACCdropdown_1_3")
	private WebElement accountSettingOption;

	@FindBy(id = "ACCdropdown_0_3")
	private WebElement accountSettingOptionShip;

	@FindBy(id = "closeButton")
	public WebElement iPerceptionclosebtn;

	@FindBy(id = "IPerceptionsEmbed")
	public WebElement iPerceptionframe;

	private PageData footer;

	public FooterPage (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate(){
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
	} */

	/* tbd 
	public void feebackpopupClose_shortwait() throws InterruptedException
	{ //waitForloader(driver,overlay, 20);
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
		//tbd Thread.sleep(5000);
		//feebackpopupClose();
		String section="Member support and Quick links";
		Assert.assertTrue("PROBLEM - unable to locate 'Help and Contact Us' on '"+section+"' section", footerValidate(HelpandContactUs));
		Assert.assertTrue("PROBLEM - unable to locate 'Account Settings' on '"+section+"' section", footerValidate(AccountSettings));
		Assert.assertTrue("PROBLEM - unable to locate 'Legal Notices And Disclosures' on '"+section+"' section", footerValidate(LegalNoticesAndDisclosures));
		Assert.assertTrue("PROBLEM - unable to locate 'Accessibility' on '"+section+"' section", footerValidate(Accessibility));
		Assert.assertTrue("PROBLEM - unable to locate 'Logout' on '"+section+"' section", footerValidate(Logout));
		System.out.println("======================"+section+" are displayed =========================");

		//tbd if (HelpandContactUs.isDisplayed() && AccountSettings.isDisplayed() 
		//tbd 		&& LegalNoticesAndDisclosures.isDisplayed() 
		//tbd 		&& Accessibility.isDisplayed() 
		//tbd 		&& Logout.isDisplayed()){
			//  Saved.isDisplayed() is not displayed for every page.
		//tbd 	System.out.println("======================Member support and Quick links are displayed =========================");
		//tbd }
		//tbd else {
			//tbd 	Assert.assertFalse(false);
		//tbd }
		
		section="Bottom links";
		Assert.assertTrue("PROBLEM - unable to locate 'Other Language' on '"+section+"' section", footerValidate(OtherLanguageLink));
		Assert.assertTrue("PROBLEM - unable to locate 'Asistencia' on '"+section+"' section", footerValidate(Asistencia));
		Assert.assertTrue("PROBLEM - unable to locate 'LanguageAssistance' on '"+section+"' section", footerValidate(LanguageAssistance));
		Assert.assertTrue("PROBLEM - unable to locate 'Last Update' on '"+section+"' section", footerValidate(LastUpdate));
		Assert.assertTrue("PROBLEM - unable to locate 'Tearms Of Use' on '"+section+"' section", footerValidate(TearmsOfUse));
		Assert.assertTrue("PROBLEM - unable to locate 'United Healthcare' on '"+section+"' section", footerValidate(UnitedHealthcare));
		System.out.println("======================"+section+" are displayed =========================");
		return true;
		//tbd if (OtherLanguageLink.isDisplayed() && Asistencia.isDisplayed() 
		//tbd 		&& LanguageAssistance.isDisplayed() && LastUpdate.isDisplayed() && TearmsOfUse.isDisplayed() &&
		//tbd 		UnitedHealthcare.isDisplayed()){
		//tbd 	System.out.println("====================== Bottom links are displayed =========================");
		//tbd 	return true;
		//tbd }
		//tbd else {
		//tbd 	Assert.assertFalse(false);
			//tbd }
		//tbd return null;
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
				System.out.println("Profile and Preferance link is displayed");
				accountSettingOption.click();
				System.out.println("Profile and Preferance link is clicked");
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

	public void eobCheckModelPopup(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); 
		checkModelPopup(driver,5);
		//note: UhcDriver default is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 

	}


}


