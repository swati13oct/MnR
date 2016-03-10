/**
 * 
 */
package pages.member.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.bluelayer.LoginAssistancePage;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class LoginPage extends UhcDriver {

	private static String PAGE_URL = MRConstants.UHCM_URL;
	
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

	public Object loginWith(String username, String password, String category) {
		loginIn.click();
		sendkeys(userNameField, username);
		sendkeys(passwordField, password);
		signInButton.click();
		if(currentUrl().contains("home/my-account-home.html") && category.equalsIgnoreCase("Group"))
		{
			return new AccountHomePage(driver,category);
		}
		else if(currentUrl().contains("home/my-account-home.html") && category.equalsIgnoreCase("Individual") ) {
			return new AccountHomePage(driver, category);
		}
		else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver);
		}
		return null;
	}


	@Override
	public void openAndValidate() {
		start(PAGE_URL);
		validate(loginIn);

	}

	public LoginAssistancePage navigateToLoginAssistance() {
		loginIn.click();
		forgotUsernamePasswordLink.click();
		CommonUtility.waitForPageLoad(driver, userNameCheckBox, 5);
		if(driver.getTitle().equalsIgnoreCase("UnitedHealthcare Medicare Solutions |Username and Password Assistance"))
		{
			return new LoginAssistancePage(driver);
		}
		
		return null;
	
	}

}
