package pages.Global.Member;

import org.apache.commons.lang.Validate;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import atdd.framework.UhcDriver;

public class footer extends UhcDriver {

	//======================Member Support Frame==========================//

	@FindBy(xpath= "(.//*[@class='col-md-12'])[13]")
	private WebElement MemberSupportFrame;

	@FindBy(xpath = "(//*[@class='col-md-12']/ul/li[1])[1]/a")
	private WebElement HelpandContactUs;

	@FindBy(xpath= "(//*[@class='col-md-12']/ul/li[1])[2]/a")
	private WebElement AccountSettings;

	@FindBy(xpath= "(//*[@class='col-md-12']/ul/li[2])[1]/a")
	private WebElement LegalNoticesAndDisclosures;

	//======================Quick links==========================//

	@FindBy(xpath= "(.//*[@class='col-md-12'])[15]")
	private WebElement QuickLinksFrame;

	@FindBy(xpath= "(//*[@class='col-md-12']/ul/li[2])[2]/a")
	private WebElement Saved;

	@FindBy(xpath= "(//*[@class='col-md-12']/ul/li[3])[1]/a")
	private WebElement Accessibility;

	@FindBy(xpath= "(//*[@class='col-md-12']/ul/li[3])[1]/a")
	private WebElement Logout;

	/*======================Bottom Frame=========================*/

	@FindBy(xpath= "(.//*[@class='col-md-12'])[14]")
	private WebElement Frame1;

	@FindBy(xpath= "(.//*[@class='col-md-12'])[16]")
	private WebElement Frame2;



	@FindBy(xpath= "(.//*[@class='col-md-12'])[14]/p[1]")
	private WebElement UnitedHealthcare;

	@FindBy(xpath= "(.//*[@class='col-md-12'])[14]/p[2]")
	private WebElement TearmsOfUse;

	@FindBy(xpath= "(.//*[@class='col-md-12'])[14]/p[3]")
	private WebElement LastUpdate;

	@FindBy(xpath= "(.//*[@class='col-md-12'])[16]/p[1]/a")
	private WebElement LanguageAssistance;

	@FindBy(xpath= "(.//*[@class='col-md-12'])[16]/p[2]/a")
	private WebElement Asistencia;

	@FindBy(xpath= "(.//*[@class='col-md-12'])[16]/p[3]/a")
	private WebElement OtherLanguageLink;

	public footer(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
 	}


	@Override
	public void openAndValidate(){
		// TODO Auto-generated method stub
 
	}

	public Boolean validateFooterLinks(){
 		if(MemberSupportFrame.isDisplayed() && QuickLinksFrame.isDisplayed()){
			System.out.println("MemberSupportFrame is displayed");
			if (HelpandContactUs.isDisplayed() && AccountSettings.isDisplayed() 
					&& LegalNoticesAndDisclosures.isDisplayed() && Accessibility.isDisplayed() && Saved.isDisplayed() &&
					Logout.isDisplayed()){
				System.out.println("======================Member support and Quick links are displayed =========================");
				return true;
			}
			else{

				System.out.println("======================Member support and Quick links are not displayed =========================");
				Assert.fail();
			} 	
		}

		if (Frame1.isDisplayed() && Frame2.isDisplayed()){
			if (OtherLanguageLink.isDisplayed() && Asistencia.isDisplayed() 
					&& LanguageAssistance.isDisplayed() && LastUpdate.isDisplayed() && TearmsOfUse.isDisplayed() &&
					UnitedHealthcare.isDisplayed()){
				System.out.println("====================== Bottom links are displayed =========================");
				return true;
			}
			else{

				System.out.println("======================Bottom frames are displayed =========================");
				Assert.fail();
			} 	



		}

		System.out.println("MemberSupportFrame is displayed");
		return false;
	}
}


