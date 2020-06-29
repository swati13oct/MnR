/**
 * 
 */
package pages.memberrdesignVBF.hsidRegistration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class HSIDLoginPage extends UhcDriver {

	// Page URL
	//private static String PAGE_URL = MRConstants.HSIDURL;

	

	@FindBy(id = "fd_memberSignInButton")
	private WebElement loginIn;

	@FindBy(id = "hsid-username")
	private WebElement userNameField;

	@FindBy(id = "hsid-password")
	private WebElement passwordField;

	@FindBy(id = "hsid-submit")
	private WebElement signInButton;
	
	@FindBy(id = "hsid-FUn")
	private WebElement usernamelink;
	
	@FindBy(id = "hsid-FPwd")
	private WebElement passwordlink;
	
    @FindBy(xpath=".//*[@id='IPEinvL']/map/area[1]")
    private WebElement iPerceptionPopUp;
    
    @FindBy(xpath ="//div[@id='hsid-commonError']/p/span[2]")
    private WebElement EmailConfirmedtext;
    
    @FindBy(xpath=".//*[@id='hsid-login']/div[2]/p[3]/a")
	private WebElement registerNow;
    
    private static String REGIRATION_URL = "https://st1.healthsafe-id.com/protected/register?HTTP_TARGETPORTAL=MNR&HTTP_ERRORURL=https://stage-medicare.uhc.com/&HTTP_TARGETURL=https%3A%2F%2Fstage-medicare.uhc.com%2Fmember%2Fpost-sign-in.html%3Ftarget%3Drallydashboard%26portalIndicator%3DUHC&HTTP_ELIGIBILITY=P&HTTP_GRADIENTCOLOR1=%23003DA1&HTTP_GRADIENTCOLOR2=%2300A8F7&HSID_DOMAIN_URL=https://st1.healthsafe-id.com&USE_TEST_RECAPTCHA=true";
	
    
MRScenario loginScenario;
	
	public MRScenario getLoginScenario() {
		MRScenario loginScenario = null;
		return loginScenario;
	}

	public HSIDLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	public void openAndValidate() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//start(PAGE_URL);
	}
	
	public void validateelements()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(userNameField);
		validate(passwordField);
		validate(signInButton);
		validate(usernamelink);
		validate(passwordlink);
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
	
	
	
	/**
	 * @toDo : To login through hsid via entering security questions
	 *//*
	public Object doLoginWith(String username, String password) {

        System.out.println(driver.getCurrentUrl());
		sendkeys(userNameField, username);
		sendkeys(passwordField, password);
		signInButton.click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (driver.getCurrentUrl().contains("aa-web/evaluate?execution=e1s2&action=securityQuestion"))
		{
			
			
			ConfirmSecurityQuestion cs = new ConfirmSecurityQuestion(driver);
		    try {
				cs.enterValidSecurityAnswer();
				System.out.println(driver.getCurrentUrl());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		else if(currentUrl().contains("testharness.html") || currentUrl().contains("/dashboard"))
		{
			
				
				System.out.println(driver.getCurrentUrl());
			    return new AccountHomePage(driver);
		}
		
		else
		{
			System.out.println("teamhloginWith is returing null. Please Update the above condition As per your Needs");
		}
		
		if ( MRScenario.environmentMedicare.equals("team-e") || MRScenario.environmentMedicare.equals("team-ci1")){

			Alert alert = driver.switchTo().alert();
			alert.accept();
		} 
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		if(currentUrl().contains("testharness.html") || currentUrl().contains("/dashboard"))
        {
			
			System.out.println(driver.getCurrentUrl());
			return new AccountHomePage(driver);
		}
		else if(currentUrl().contains("home/my-account-home.html")  || currentUrl().contains("/login.html") ) {
			return new AccountHomePage(driver);
		}
		else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver);
		}

		

		return null;
	}
*/
	private char[] getcurrenturl() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void emailconfirmed() {
		// TODO Auto-generated method stub
		
		Assert.assertTrue("Text not present", EmailConfirmedtext.isDisplayed());
	}
	
	
	
	}


