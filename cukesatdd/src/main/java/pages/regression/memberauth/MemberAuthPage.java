package pages.regression.memberauth;

import java.util.ArrayList;

import org.json.JSONObject;
//import junit.framework.Assert;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.regression.accounthomepage.AccountHomePage;

/**
 * @author agoyal24
 *
 */

public class MemberAuthPage extends UhcDriver {
	
	
	public JSONObject loginPageJson;
	
	@FindBy(id = "loginusername")
	private WebElement username;
	
	@FindBy(id= "loginpassword")
	private WebElement password;
	
	@FindBy(id="find_searchbtn")
	private WebElement search;
	
	@FindBy(xpath =".//*[@id='memAuthLoginBox']//span[@class='redError']")
	private WebElement unpswdIncorrecterrormsg;
	
	@FindBy(id="userName")
	private WebElement memberUsername;
	
	@FindBy(xpath ="//*[@class='btn-group']//span[@class='btn btn--primary findFacilityBtn']")
	private WebElement FinalSearchButton;
	
	@FindBy(xpath ="//*[@class='searchResults']/table/tbody/tr[2]/td[1]/a")
	private WebElement MemberTableUserName;
	
	@FindBy(xpath ="//*[@class='modal-content']//div[@role='document']//div[@class='btn-group--full-width loginbutton']/a[1]")
	private WebElement MemberPopUpLogin;
	
	@FindBy(xpath = "//*[@id='sticky-nav']//div[@ng-switch-when='M&R']/a[5]")
	private WebElement PremiumPayment;
	
	private static String MEMBER_AUTH = MRConstants.MEMBER_AUTH;
	
	public MemberAuthPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		
	}
	/** 
	 * @todo : Login to app
	 */
	public MemberAuthPage navigateToLoginURL(){
		start(MEMBER_AUTH);
		//driver.get("https://www.team-c-generic.uhc.com/content/dashboard/guest/memberauth.html#/memberAuthLogin");
		CommonUtility.waitForPageLoad(driver, username, 60);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(driver.getTitle().equals("memberauth")){
			return new MemberAuthPage(driver);
		}
		return null;
	}
	
	/** 
	 * @todo : Validate Error message
	 */
	public MemberAuthPage validateErrorMessage(String loginname, String  loginpassword, String Errormessage) throws InterruptedException{
		username.sendKeys(loginname);
		password.sendKeys(loginpassword);
		search.click();
		Thread.sleep(5000);
		if (!(unpswdIncorrecterrormsg.isDisplayed())){
						Assert.fail("Error message mismatch");
			
		}
		//if(!(this.unpswdIncorrecterrormsg.getText().trim().contains(Errormessage)))
		
		return null;
			
	}
	
	public MemberAuthPage FirstLogin(String loginname, String  loginpassword) throws InterruptedException{
		username.sendKeys(loginname);
		password.sendKeys(loginpassword);
		search.click();
		waitforElement(memberUsername);
		if (memberUsername.isDisplayed()){
			System.out.println("member auth Login successfull");			
			return new MemberAuthPage(driver);		
			}
		else		
		return null;			
	}
	
	public MemberAuthPage MainMemberLogin(String MemberUserName) throws InterruptedException{
		memberUsername.clear();
		memberUsername.sendKeys(MemberUserName);		
		FinalSearchButton.click();
		
		waitforElement(MemberTableUserName);
		if (MemberTableUserName.isDisplayed()){
			System.out.println("member Username under the table is displayed");	
			MemberTableUserName.click();
			return new MemberAuthPage(driver);		
			}
		else
			System.out.println("Member UserName Not found");
		return null;			
	}
	
	public AccountHomePage PopupClick() throws InterruptedException{
		
		waitforElement(MemberPopUpLogin);
		Thread.sleep(2000);
		if (MemberPopUpLogin.isDisplayed()){
			System.out.println("Pop up Login Button is displayed");	
			Thread.sleep(2000);
			MemberPopUpLogin.click();	
			System.out.println("popup login button clicked");
			Thread.sleep(20000);
			switchToNewTab();
			System.out.println("Switched to new tab");
		    Thread.sleep(10000);
		    waitforElement(PremiumPayment);
		    if(PremiumPayment.isEnabled())
		    {
		    PremiumPayment.click();		    
			return new AccountHomePage(driver);		
			}else
			{
				System.out.println("Payment Link not displayed");
			}
		}
		else
			System.out.println("Member Pop up Login not found");
		return null;			
	}
	
public MemberAuthPage NewTabValidation() throws InterruptedException{		
	
	    
	   
	    
		waitforElement(PremiumPayment);
		if (PremiumPayment.isDisplayed()){
			System.out.println("Premium Payment link is displayed");	
			PremiumPayment.click();
			return new MemberAuthPage(driver);		
			}
		else
			System.out.println("Premium Payment Link not found");
		return null;			
	}
	
}

