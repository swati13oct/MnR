package pages.Global.Member;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	public Object validateFooterLinks() throws InterruptedException{
		
		Thread.sleep(10000);
		
		
		
			
				if (HelpandContactUs.isDisplayed() && AccountSettings.isDisplayed() 
						&& LegalNoticesAndDisclosures.isDisplayed() && Accessibility.isDisplayed() && Saved.isDisplayed() &&
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
			
				
					
					



	
	
	
	public ClaimSummarypage NavigateToClaimsPage(){
		validate(claimsLink);
		if(claimsLink.isDisplayed()){
		System.out.println("Claims link is displayed");
		claimsLink.click();
		System.out.println("Claims link is clicked");
		
		
		}
		
		
		return null;
	}
	  public Footer validatePageFooter(){
		  	  
		  	 
		  	 return new Footer(driver);
	  }
}


