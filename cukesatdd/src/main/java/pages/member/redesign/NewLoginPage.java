/**
 * 
 */
package pages.member.redesign;


import org.json.JSONException;
import org.json.JSONObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.ulayer.LoginAssistancePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class NewLoginPage extends UhcDriver {

	// Page URL
	private static String PAGE_URL = MRConstants.AARPM_URL;
	private static String REDESIGN_PAGE_URL = MRConstants.REDESIGN_AARPM_URL;

	@FindBy(id = "sign-in-btn")
	private WebElement btnSignIn;

	@FindBy(id = "username")
	private WebElement userNameField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(linkText = "Forgot your username or password?")
	private WebElement forgotUsernamePasswordLink;

	@FindBy(id = "usercheckbox")
	private WebElement userNameCheckBox;
	
	@FindBy(xpath=".//*[@id='IPEinvL']/map/area[2]")
    private WebElement iPerceptionPopUp;


	public NewLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public Object loginWith(String username, String password) {
			
		try{
			sendkeys(userNameField,username);
			sendkeys(passwordField,password);
			btnSignIn.click();
			Thread.sleep(4000);
			if (MRScenario.environment.equals("team-e")/* || MRScenario.environment.equals("team-h")*/){
					Alert alert2 = driver.switchTo().alert();
					alert2.accept();
			}
			Thread.sleep(5000);
            if (iPerceptionPopUp.isDisplayed()) {
                iPerceptionPopUp.click();
                System.out.println("iPerception Pop Up not displayed");
         }
		Thread.sleep(20000);
		}catch (InterruptedException e) {
				e.printStackTrace();
			}
		if(currentUrl().contains("member/testharness.html"))
		{
			return new TestHarnessPage(driver);
		}
		return null;
	}
	@Override
	public void openAndValidate() {
		start(MRConstants.NEW_REDESIGN_URL);
		validate(btnSignIn);
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
}
