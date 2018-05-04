package pages.dashboard.memberAuth;

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

public class MemberAuthLoginPage extends UhcDriver {
	
	
	public JSONObject loginPageJson;
	
	@FindBy(id = "loginusername")
	private WebElement username;
	
	@FindBy(id= "loginpassword")
	private WebElement password;
	
	@FindBy(id="find_searchbtn")
	private WebElement search;
	
	@FindBy(xpath =".//*[@id='memAuthLoginBox']//span[@class='redError']")
	private WebElement unpswdIncorrecterrormsg;
	
	private static String MEMBER_AUTH = MRConstants.MEMBER_AUTH;
	
	public MemberAuthLoginPage(WebDriver driver) {
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
	public MemberAuthLoginPage navigateToLoginURL(){
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
			return new MemberAuthLoginPage(driver);
		}
		return null;
	}
	
	/** 
	 * @todo : Validate Error message
	 */
	public MemberAuthLoginPage validateErrorMessage(String loginname, String  loginpassword, String Errormessage) throws InterruptedException{
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
}
