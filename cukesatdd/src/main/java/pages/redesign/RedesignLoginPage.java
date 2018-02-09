/**
 * 
 */
package pages.redesign;

import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.acquisition.bluelayer.LoginAssistancePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
/**
* Functionality: Redesign login page
*/
public class RedesignLoginPage extends UhcDriver {


	//private static String PAGE_URL = MRConstants.MEDICARE_UHC_REDESIGN;
	private static String PAGE_URL = MRConstants.REDESIGN_LOGIN_URL;
	
	//private static String CI_PAGE_URL = MRConstants.REDESIGN_LOGIN_URL; 
	
	
	@FindBy(xpath = "//area[@href='javascript:clWin()'][@alt = 'close']")
	private WebElement FeedbackModal;

	@FindBy(id = "username")
	private WebElement userNameField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "sign-in-btn")
	private WebElement signInButton;

	@FindBy(linkText = "Forgot your username or password?")
	private WebElement forgotUsernamePasswordLink;

	@FindBy(id = "usercheckbox")
	private WebElement userNameCheckBox;
	
	@FindBy(id = "new-email")
	private WebElement NewEmailTxtBox;

	@FindBy(id = "new-email-confirm")
	private WebElement ConfirmNewEmailTxtBox;
	
	@FindBy(xpath = "//*[@id='email-modal-form']//button")
	private WebElement NewEmailContinueBtn;

	/**
	* @todo : Redesign login 
	*/
	public RedesignLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public Object loginWith(String username, String password) throws InterruptedException {
		sendkeys(userNameField,username);
		sendkeys(passwordField,password);
		System.out.println(signInButton.isEnabled());
		signInButton.click();
		Thread.sleep(25000);
		
		if ( MRScenario.environment.equals("team-h") || MRScenario.environment.equals("team-a") || MRScenario.environment.equals("team-ci1")) {
			while (isAlertPresent());

/*			try{
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
			catch(Throwable e) {
				System.out.println("Alert isn't present!!");
			} 
*/		}
		
		Thread.sleep(50000);
		CommonUtility.checkPageIsReady(driver);
/*		try{
			if(validate(NewEmailTxtBox)){
			NewEmailTxtBox.sendKeys("uhcmnrportals@gmail.com");
			ConfirmNewEmailTxtBox.sendKeys("uhcmnrportals@gmail.com");
			System.out.println("@@@@@@@@@@@@ Enter New Email Page Displayed for ULayer Member@@@@@@@@@@@@");
			NewEmailContinueBtn.click();
			Thread.sleep(3000);
			CommonUtility.checkPageIsReady(driver);
			}
		}
		catch (Exception e) {
			System.out.println("New Email Page NOT Present");
		}

*/		try{
			FeedbackModal.click();
			System.out.println("FeedBack Modal Present");
			if (validate(FeedbackModal)){
				System.out.println("FeedBack Modal NOT CLOSING - Close button is clicked");
			}
			System.out.println("FeedBack Modal Closed");
			Thread.sleep(3000);
		}
		catch (Exception e) {
			System.out.println("FeedBack Modal NOT Present");

		}

		if (currentUrl().contains("/testharness")){
			System.out.println("@@@@@@@@@@@@ Redesign Testharness Page Displayed for Member@@@@@@@@@@@@");
			return new UlayerHomePage(driver);
		}
		

	if (currentUrl().contains("/dashboard")){
			System.out.println("@@@@@@@@@@@@ Rally Dashboard Page Displayed for Member @@@@@@@@@@@@");
			return new UlayerHomePage(driver);
		}
		System.out.println("@@@@@@@@@@@@ Account Home Page is NOT DISPLAYED @@@@@@@@@@@@");
		return null;
	}
	/**
	* @todo : user name valdiation 
	*/
	@Override
	public void openAndValidate() {
/*		if(MRScenario.environment.contentEquals("test-a") || MRScenario.environment.contentEquals("stage")){
			start(PAGE_URL);
		}
		if(MRScenario.environment.contentEquals("team-ci1")){
			start(CI_PAGE_URL);
		}
*/		
		start(PAGE_URL);
		validate(userNameField);
		System.out.println("@@@@@@@@@@@@@  Test Environment and URL  : "+PAGE_URL+"  @@@@@@@@@@@@@@@@@@@@@@@");
	}
	/**
	* @todo : click on forgot password
	*/
	public LoginAssistancePage navigateToLoginAssistance() {
		forgotUsernamePasswordLink.click();
		CommonUtility.waitForPageLoad(driver, userNameCheckBox, 5);
		if(driver.getTitle().equalsIgnoreCase("UnitedHealthcare Medicare Solutions |Username and Password Assistance"))
		{
			return new LoginAssistancePage(driver);
		}

		return null;

	}

	/**
	* @todo : wait for dashboard page to load
	*/
	public boolean isAlertPresent(){ 
	    try{ 
	        Alert a = new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
/*	        if(a!=null){
	            System.out.println("Alert is present = " + a.getText());
	            driver.switchTo().alert().accept();
	            Alert a2 = new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
	            if(a2!=null){
		            System.out.println("Alert is present = " + a2.getText());
		            
		            driver.switchTo().alert().accept();
	            }
	            //return true;
	        }
*/            
	        System.out.println("Alert is present = " + a.getText());
            driver.switchTo().alert().accept();
	        return true;
	        /*else{
	            //throw new Throwable();
	        	System.out.println("alert is not present 1");
	        	return false;
	        }*/
	    } 
	    catch (Throwable e) {
	        System.out.println("Alert isn't present!!");
	        return false; 
	    } 

	} 

}
