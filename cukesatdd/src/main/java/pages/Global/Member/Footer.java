package pages.Global.Member;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.itextpdf.text.log.SysoCounter;

import acceptancetests.data.PageData;
import atdd.framework.UhcDriver;
import pages.regression.claims.ClaimSummarypage;

public class Footer extends UhcDriver {

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


	

	@FindBy(xpath= "//footer//div[contains(@class,'iparys_inherited')]/div/div/div[1]//div[@class='row footerLinks']//p[1]")
	private WebElement UnitedHealthcare;

	@FindBy(xpath= "//footer//div[contains(@class,'iparys_inherited')]/div/div/div[1]//div[@class='row footerLinks']//p[2]")
	private WebElement TearmsOfUse;

	@FindBy(xpath= "//footer//div[contains(@class,'iparys_inherited')]/div/div/div[1]//div[@class='row footerLinks']//p[3]")
	private WebElement LastUpdate;

	@FindBy(xpath= "//footer//div[contains(@class,'iparys_inherited')]/div/div/div[2]//div[@class='row footerLinks']//p[1]")
	private WebElement LanguageAssistance;

	@FindBy(xpath= "//footer//div[contains(@class,'iparys_inherited')]/div/div/div[2]//div[@class='row footerLinks']//p[2]")
	private WebElement Asistencia;

	@FindBy(xpath= "//footer//div[contains(@class,'iparys_inherited')]/div/div/div[2]//div[@class='row footerLinks']//p[3]")
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
	private WebElement accountprofile;
	
	@FindBy(xpath = ".//*[@id='dropdown-options--1']/a[2]")
	private WebElement accountSettingOption;
	
	@FindBy(id = "closeButton")
	public WebElement iPerceptionclosebtn;
	
	@FindBy(id = "IPerceptionsEmbed")
	public WebElement iPerceptionframe;
	
	private PageData footer;

	public Footer(WebDriver driver) {
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

	public Object validateFooterLinks() throws InterruptedException{
		
		
		
		Thread.sleep(10000);
		
		feebackpopupClose();
		
			
				if (HelpandContactUs.isDisplayed() && AccountSettings.isDisplayed() 
						&& LegalNoticesAndDisclosures.isDisplayed() 
						&& Accessibility.isDisplayed() 
						&& Saved.isDisplayed() &&
						Logout.isDisplayed()){
			
				System.out.println("======================Member support and Quick links are displayed =========================");
				
				}
				else {
					Assert.assertFalse(false);
				}
	
		
			if (OtherLanguageLink.isDisplayed() && Asistencia.isDisplayed() 
					&& LanguageAssistance.isDisplayed() && LastUpdate.isDisplayed() && TearmsOfUse.isDisplayed() &&
					UnitedHealthcare.isDisplayed()){
					
				System.out.println("====================== Bottom links are displayed =========================");
				return true;
			}
			else {
				Assert.assertFalse(false);
			}
			return null;}
			
				
	public Footer NavigateToClaimsPage(){
		validate(claimsLink);
		if(claimsLink.isDisplayed()){
		System.out.println("Claims link is displayed");
		claimsLink.click();
		System.out.println("Claims link is clicked");
		
		
		}
		
		
		return null;
	}	
			
	
	public Footer NavigateToEOBPage(){
		validate(EOBLink);
		if(EOBLink.isDisplayed()){
		System.out.println("EOB link is displayed");
		EOBLink.click();
		System.out.println("EOB link is clicked");
				
		}
				
		return null;
			}

	public Footer NavigateToContactUsPage(){
		validate(HelpandContactUs);
		if(HelpandContactUs.isDisplayed()){
		System.out.println("contactUSLink link is displayed");
		HelpandContactUs.click();
		System.out.println("contactUS link is clicked");
				
		}
				
		return null;
			}
	
	public Footer NavigateToBenefitsPage(){
		validate(benefits);
		if(benefits.isDisplayed()){
		System.out.println("Benefits link is displayed");
		benefits.click();
		System.out.println("Benefits link is clicked");
				
		}
				
		return null;
			}
	
	public Footer NavigateToPharmacyLocator(){
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

	public Footer NavigateToDCE(){
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
	
	public Footer NavigateToProfileandPref(){
		validate(homeBtn);
		if(homeBtn.isDisplayed()){
			System.out.println("Home button is displayed");
			waitforElement(homeBtn);
			homeBtn.click();
			System.out.println("Home button is clicked");
			
			waitforElement(accountprofile);
			if(accountprofile.isDisplayed()){
				accountprofile.click();
				waitforElement(accountSettingOption);
				System.out.println("Profile and referance link is displayed");
				accountSettingOption.click();
				System.out.println("Profile and referance link is clicked");
			}
		}
			return null;
			
	}
	

	
	
	
	
	  public Footer validatePageFooter(){
		  	  
		  	 
		  	 return new Footer(driver);
	  }
}


