/**
 * 
 */
package pages.member.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
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

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public void loginWith(String username, String password) {
		loginIn.click();
		sendkeys(userNameField, username);
		sendkeys(passwordField, password);
		signInButton.click();
	}

	public Object checkIfLoginSuccessful() {
		/*
		 * if (this.driver.getTitle().equalsIgnoreCase(
		 * "UnitedHealthcare Medicare Solutions | My Account Home")) { return
		 * new AccountHomePage(driver); } else if
		 * (this.driver.getCurrentUrl().contains("terminated-plan.html")) {
		 * return new TerminatedHomePage(driver); }
		 */
		return null;
	}

	public Object checkLoginSuccessful() {
		if (getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | My Account Home")) {
			return new AccountHomePage(driver);
		} else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver);
		}
		return null;
	}
	
	public Object checkLoginSuccessful(String category) {
		if (getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | My Account Home")  && category.equalsIgnoreCase("Group")) {
			return new AccountHomePage(driver,category);
		} 
		else if(getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | My Account Home")) {
			return new AccountHomePage(driver);
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

}
