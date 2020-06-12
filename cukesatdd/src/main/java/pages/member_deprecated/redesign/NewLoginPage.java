/**
 * 
 */
package pages.member_deprecated.redesign;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.dashboard_deprecated.acquisition.RegistrationInformationPage;
import pages.dashboard_deprecated.eob.EOBPage;
import pages.member_deprecated.bluelayer.DashboardPage;
import pages.member_deprecated.ulayer.TerminatedHomePage;
import pages.member_deprecated.ulayer.UNPWAssistancePage;

/**
 * @author pjaising
 *
 */
public class NewLoginPage extends UhcDriver {

	private static final String STAGE_DASHBOARD_URL = null;

	// Page URL
	private static String PAGE_URL = MRConstants.DASHBOARD_URL;

	@FindBy(id = "sign-in-btn")
	private WebElement btnSignIn;

	@FindBy(id = "username")
	private WebElement userNameField;

	@FindBy(id = "password")
	private WebElement passwordField;
	
	@FindBy(id = "regbutton")
	private WebElement registerButton;

	@FindBy(linkText = "Forgot your username or password?")
	private WebElement forgotUsernamePasswordLink;

	@FindBy(id = "usercheckbox")
	private WebElement userNameCheckBox;

	public NewLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public Object loginWith(String username, String password) throws InterruptedException {
		System.out.println("---------------------inside loginWith---------------------------" + username);
		waitforElement(userNameField);
		sendkeys(userNameField,username);
		sendkeys(passwordField,password);
		btnSignIn.click();
		System.out.println("Sign In clicked");



		try{
		System.out.println();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		}catch(Exception e) {
		System.out.println("No Such alert displayed");
		}
		/*if (!(MRScenario.environment.equals("awe-dev-b") || MRScenario.environment.equals("dev-c") || MRScenario.environment.equals("team-b"))){
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();
		}*/
		          
		Thread.sleep(70000);
		System.out.println("30 secondss completed");
		if(currentUrl().contains("/dashboard"))

		{
		
		return new DashboardPage(driver);
		}
		else if (currentUrl().contains("terminated-plan.html")) {
		return new TerminatedHomePage(driver); 
		}
		return null;
		}
	@Override
	public void openAndValidate() {
		start(PAGE_URL);
		}

	public static boolean isAlertPresent(WebDriver wd) {
		try {
			Alert alert = wd.switchTo().alert();
			alert.dismiss();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		} catch (UnsupportedCommandException e) {
			System.out.println("WebDriver doesn't support switchTo() method");
			return false;
		}
	}
	
    public void navigateToNewDashboardUrls(){
        if (MRScenario.environmentMedicare.equalsIgnoreCase("stage"))
        {
               start(PAGE_URL);
               System.out.println("User is Navigating to Stage Dashboard");
        }
       
}


	
    /**
     * Navigate to registration page
     *
     * @return the registration page
     */
    public RegistrationInformationPage navigateToRegistration() {
    	registerButton.click();
    	return new RegistrationInformationPage(super.driver);
    }
    
    /** Navigate to username password assisatnce page
    *
    * @return the username password assisatnce page
    */
    
    public UNPWAssistancePage navigateToUNPWassistance(){
    	forgotUsernamePasswordLink.click();    	
    	return new UNPWAssistancePage(super.driver);
    }
    
    public EOBPage loginToDashboardPage(String userName){
		System.out.println(MRScenario.environment);
	
		if(MRScenario.environment.contains("stage")){
			start(STAGE_DASHBOARD_URL);
			System.out.println(STAGE_DASHBOARD_URL);
		}else{
			start(MRConstants.REDESIGN_LOGIN_URL);
		}
		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
		System.out.println(userName);
		validate(driver.findElement(By.id("username")));
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys("Password@1");
		driver.findElement(By.id("sign-in-btn")).click();
		return new EOBPage(driver);
	}
    
}

    
    
