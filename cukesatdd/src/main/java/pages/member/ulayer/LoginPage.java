/**
 * 
 */
package pages.member.ulayer;

import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.ulayer.LoginAssistancePage;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class LoginPage extends UhcDriver {

	// Page URL
	private static String PAGE_URL = MRConstants.AARPM_URL;

	@FindBy(id = "fd_memberSignInButton")
	private WebElement loginIn;

	@FindBy(id = "loginPOPUPuser")
	private WebElement userNameField;

	@FindBy(id = "loginPOPUPpass")
	private WebElement passwordField;

	@FindBy(xpath = "//div[@class='fd_userPassSection']/button")
	private WebElement signInButton;

	@FindBy(linkText = "Forgot your username or password?")
	private WebElement forgotUsernamePasswordLink;
	
	@FindBy(id = "usercheckbox")
	private WebElement userNameCheckBox;
		 

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public void loginWith(String username, String password) {
		loginIn.click();	
		sendkeys(userNameField,username);
		sendkeys(passwordField,password);
		signInButton.click();
	}

	
	public Object checkLoginSuccessful(){
		if (getTitle().equalsIgnoreCase(
				"AARP Medicare Plans | My Account Home")) {
			return new AccountHomePage(driver);
		} else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver);
		}
		return null;
	}
	
	public LoginAssistancePage navigateToLoginAssistance() {
		loginIn.click();
		forgotUsernamePasswordLink.click();
		CommonUtility.waitForPageLoad(driver, userNameCheckBox, 5);
		if(driver.getTitle().equalsIgnoreCase("AARP Medicare Plans |Username and Password Assistance"))
		{
			return new LoginAssistancePage(driver);
		}
		
		return null;
	
	}


	@Override
	public void openAndValidate() {
		start(PAGE_URL);
		validate(loginIn);
		
	}
}
