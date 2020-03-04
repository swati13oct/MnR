package pages.regression.footer;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.data.PageData;
import atdd.framework.UhcDriver;

public class FooterPage extends UhcDriver {

	//======================Member Support ==========================//

	@FindBy(xpath= "(.//*[@class='col-md-12'])[13]")
	private WebElement MemberSupportFrame;

	@FindBy(id = "contact-help")
	private WebElement HelpandContactUs;

	@FindBy(id= "notices")
	private WebElement NoticesAndDisclosures;

	@FindBy(linkText= "Saved")
	private WebElement Saved;

	@FindBy(id= "accessibility")
	private WebElement AccessibilityStatement;
	
	@FindBy(id= "provider-data")
	private WebElement ProviderDataInformation;
	
	@FindBy(id= "legal-entities")
	private WebElement LegalEntities;
	
	@FindBy(id= "share-feedback")
	private WebElement ShareFeedback  ;
	
	@FindBy(id= "language-assistance")
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

	private PageData footer;

	public FooterPage (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void openAndValidate(){
		// TODO Auto-generated method stub
	}
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
	}

	public Object validateFooterLinks() throws InterruptedException{
		Thread.sleep(5000);
		if (HelpandContactUs.isDisplayed()
				&& NoticesAndDisclosures.isDisplayed() 
				&& AccessibilityStatement.isDisplayed()
				&& ProviderDataInformation.isDisplayed()
				&& LegalEntities.isDisplayed()
				&& ShareFeedback.isDisplayed()){
			System.out.println("======================Member support and Quick links are displayed =========================");
		}
		else {
			Assert.assertFalse(false);
		}
		
		if (LanguageAssistance.isDisplayed() && LanguageAssistanceSpanish.isDisplayed() && LanguageAssistanceChinese.isDisplayed())
		{
			System.out.println("====================== Bottom links are displayed =========================");
			return true;
		}
		else {
			Assert.assertFalse(false);
		}
		return null;}
	
	public FooterPage NavigateToClaimsPage(){
		validate(claimsLink);
		if(claimsLink.isDisplayed()){
			System.out.println("Claims link is displayed");
			claimsLink.click();
			System.out.println("Claims link is clicked");
		}
		return null;
	}	

	public FooterPage NavigateToEOBPage(){
		validate(EOBLink);
		if(EOBLink.isDisplayed()){
			System.out.println("EOB link is displayed");
			EOBLink.click();
			System.out.println("EOB link is clicked");
		}
		return null;
	}

	public FooterPage NavigateToContactUsPage(){
		validate(HelpandContactUs);
		if(HelpandContactUs.isDisplayed()){
			System.out.println("contactUSLink link is displayed");
			HelpandContactUs.click();
			System.out.println("contactUS link is clicked");
		}
		return null;
	}

	public FooterPage NavigateToBenefitsPage(){
		validate(benefits);
		if(benefits.isDisplayed()){
			System.out.println("Benefits link is displayed");
			benefits.click();
			System.out.println("Benefits link is clicked");
		}
		return null;
	}

	public FooterPage NavigateToPharmacyLocator(){
		validate(homeBtn);
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
		validate(homeBtn);
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
		validate(accountprofile);
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
		validate(accountprofile);
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

}


