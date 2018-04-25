package pages.redesign;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;

public class HsidLoginPage extends UhcDriver {
	////button[contains(.,'Register now')]
	@FindBy(xpath=".//*[@id='hsid-login']/div[2]/p[3]/a")
	private WebElement registerNow;
	
	@FindBy(id="register-Register")
	private WebElement lawwregisterNow;
	
	 @FindBy(xpath ="//div[@id='hsid-commonError']/p/span[2]")
	    private WebElement EmailConfirmedtext;
	
	
	private static String PAGE_URL = MRConstants.STAGE_DASHBOARD_NEW_DOMAIN_URL;
	
	private static String REGIRATION_URL = "https://st1.healthsafe-id.com/protected/register?HTTP_TARGETPORTAL=MNR&HTTP_ERRORURL=https://stage-medicare.uhc.com/&HTTP_TARGETURL=https%3A%2F%2Fstage-medicare.uhc.com%2Fmember%2Fpost-sign-in.html%3Ftarget%3Drallydashboard%26portalIndicator%3DUHC&HTTP_ELIGIBILITY=P&HTTP_GRADIENTCOLOR1=%23003DA1&HTTP_GRADIENTCOLOR2=%2300A8F7&HSID_DOMAIN_URL=https://st1.healthsafe-id.com&USE_TEST_RECAPTCHA=true";

	public HsidLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		start(PAGE_URL);
		
	}
	
	
	
	public HsidRegistrationPersonalInformationPage clickRegister(){
		driver.get(REGIRATION_URL);
		/*
		if(registerNow.isDisplayed()){
			registerNow.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new HsidRegistrationPersonalInformationPage(driver);
		}else{
			Assert.assertTrue("Register now button is not displayed", false);
		}*/
		return new HsidRegistrationPersonalInformationPage(driver);
	}
	
	public void emailconfirmed() {
		// TODO Auto-generated method stub
		
		Assert.assertTrue("Text not present", EmailConfirmedtext.isDisplayed());
	}

}
